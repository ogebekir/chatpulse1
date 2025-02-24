package com.example.chatpulse.data

import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*
import java.util.regex.Pattern

class ChatAnalyzer(private val chatContent: String) {
    private val messages: List<Message> = parseMessages()

    private fun parseMessages(): List<Message> {
        val pattern = Pattern.compile("(\\d{2}/\\d{2}/\\d{4}, \\d{2}:\\d{2}) - ([^:]+): (.+)")
        val messages = mutableListOf<Message>()
        chatContent.split("\n").forEach { line ->
            val matcher = pattern.matcher(line)
            if (matcher.find()) {
                val timestamp = DateParser.parseDate(matcher.group(1)) ?: return@forEach
                val sender = matcher.group(2).trim()
                val content = matcher.group(3)
                messages.add(Message(sender, content, timestamp))
            }
        }
        return messages
    }

    fun getAnalysisResult(): AnalysisResult {
        val messageFrequency = mutableMapOf<LocalDateTime, Int>()
        val emojiStats = mutableMapOf<String, MutableMap<String, Int>>()
        val sentimentStats = mutableMapOf<String, SentimentScore>()

        messages.forEach { message ->
            val dateTime = message.timestamp.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
            messageFrequency[dateTime.toLocalDate()] = messageFrequency.getOrDefault(dateTime.toLocalDate(), 0) + 1

            val senderEmojis = emojiStats.getOrPut(message.sender) { mutableMapOf() }
            val emojiPattern = Pattern.compile("[\\uD83C-\\uD83E][\\uDD00-\\uDEFF]")
            val matcher = emojiPattern.matcher(message.content)
            while (matcher.find()) {
                senderEmojis[matcher.group()] = senderEmojis.getOrDefault(matcher.group(), 0) + 1
            }

            sentimentStats[message.sender] = SentimentAnalyzer().analyzeSentiment(message.content)
        }

        return AnalysisResult(
            messageFrequency = messageFrequency,
            emojiStats = emojiStats,
            sentimentStats = sentimentStats
        )
    }
}