package com.example.chatpulse.data

import java.time.LocalDateTime

data class AnalysisResult(
    val messageFrequency: Map<LocalDateTime, Int>,
    val emojiStats: Map<String, Map<String, Int>>,
    val sentimentStats: Map<String, SentimentScore>
)