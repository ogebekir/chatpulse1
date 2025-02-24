package com.example.chatpulse.data

import java.text.SimpleDateFormat
import java.util.*

object DateParser {
    private val DATE_FORMAT = SimpleDateFormat("dd/MM/yyyy, HH:mm", Locale.getDefault())

    fun parseDate(dateStr: String): Date? {
        return try {
            DATE_FORMAT.parse(dateStr)
        } catch (e: Exception) {
            null
        }
    }
}