package com.andigeeky.tripmate.routes

import io.ktor.server.application.*
import io.ktor.server.routing.*


fun Application.registerRoutes() {
    routing {
        tripRouting()
    }
}