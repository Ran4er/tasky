package com.tasky

import io.ktor.server.application.*
import tasky.plugins.configureLogging
import tasky.plugins.configureRouting
import tasky.plugins.configureSecurity
import tasky.plugins.configureSerialization

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureMonitoring()
    configureSecurity()
    configureLogging()
    configureSerialization()
    configureRouting()
}
