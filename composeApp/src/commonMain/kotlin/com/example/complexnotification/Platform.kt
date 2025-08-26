package com.example.complexnotification

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform