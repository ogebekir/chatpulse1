package com.example.chatpulse.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.chatpulse.data.ChatAnalyzer
import com.example.chatpulse.ui.components.AnalysisCard
import com.example.chatpulse.ui.theme.ChatPulseTheme

@Composable
fun AnalysisScreen(navController: NavController) {
    ChatPulseTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Analiz Sonuçları") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.onPrimary
                    )
                )
            }
        ) { padding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(horizontal = 16.dp)
            ) {
                item {
                    AnalysisCard(
                        title = "Mesaj Yoğunluğu",
                        content = "Toplam 500 mesaj\nEn aktif gün: 15/02/2025"
                    )
                    AnalysisCard(
                        title = "Duygu Analizi",
                        content = "Pozitif: 60%\nNegatif: 20%\nNötr: 20%"
                    )
                    AnalysisCard(
                        title = "En Çok Kullanılan Emoji",
                        content = "😊: 50 kez"
                    )
                    AnalysisCard(
                        title = "Sohbet DNA’nız",
                        content = "Benzersiz deseniniz oluşturuldu!"
                    )
                }
            }
        }
    }
}