package com.andigeeky.tripmate

import com.andigeeky.tripmate.routes.registerRoutes
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import kotlinx.serialization.json.Json

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module() {
    install(ContentNegotiation) {
        json()
    }
    install(CallLogging)
    install(StatusPages){
        exception<Throwable> { call, cause ->
            call.response.status(HttpStatusCode.InternalServerError)
            call.respond(cause.message.toString())
            throw cause
        }
        exception<CannotTransformContentToTypeException> { call, cause ->
            call.respond(HttpStatusCode.BadRequest)
            throw cause
        }
    }
    registerRoutes()
}