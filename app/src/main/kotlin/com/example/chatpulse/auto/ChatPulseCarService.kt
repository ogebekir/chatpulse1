package com.example.chatpulse.auto

import androidx.car.app.CarAppService
import androidx.car.app.Screen
import androidx.car.app.Session
import androidx.car.app.model.*

class ChatPulseCarService : CarAppService() {
    override fun createHostValidator() = HostValidator.ALLOW_ALL_HOSTS_VALIDATOR

    override fun onCreateSession(): Session = ChatPulseSession()
}

class ChatPulseSession : Session() {
    override fun onCreateScreen(intent: Intent): Screen {
        return object : Screen(carContext) {
            override fun onGetTemplate(): Template {
                return ListTemplate.Builder()
                    .setTitle("ChatPulse Analizi")
                    .setHeaderAction(Action.BACK)
                    .addItem(
                        Row.Builder()
                            .setTitle("Toplam Mesaj: 500")
                            .build()
                    )
                    .addItem(
                        Row.Builder()
                            .setTitle("En Aktif Saat: 18:00")
                            .build()
                    )
                    .build()
            }
        }
    }
}