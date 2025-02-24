package com.example.chatpulse.data

class SentimentAnalyzer {
    private val sentimentWords = mapOf(
        "happy" to 0.8, "great" to 0.9, "love" to 1.0,
        "sad" to -0.7, "angry" to -0.8, "bad" to -0.6
    )

    fun analyzeSentiment(text: String): SentimentScore {
        val words = text.lowercase().split("\\s+".toRegex())
        var positive = 0.0
        var negative = 0.0
        var count = 0

        words.forEach { word ->
            sentimentWords[word]?.let { score ->
                if (score > 0) positive += score else negative += score.absoluteValue
                count++
            }
        }

        if (count > 0) {
            positive /= count
            negative /= count
        }
        val neutral = 1.0 - (positive + negative)
        return SentimentScore(positive, negative, neutral)
    }
}