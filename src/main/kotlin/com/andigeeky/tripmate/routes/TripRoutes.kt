package com.andigeeky.tripmate.routes

import com.andigeeky.tripmate.models.Trip
import com.andigeeky.tripmate.models.tripStorage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.tripRouting() {
    route("/") {

    }
    route("/trip") {
        get {
            call.respond(tripStorage)
        }
        get("{id}") {
            val id = call.parameters["id"]
            id?.let {
                val trip = tripStorage.find { it.id == id }
                trip?.let {
                    call.respond(it)
                } ?: call.respondText("No trip with id $id", status = HttpStatusCode.NotFound)
            } ?: call.respondText("Missing or malformed id", status = HttpStatusCode.BadRequest)
        }
        post {
            val trip = call.receive<Trip>()
            tripStorage.add(trip)
            call.respondText("Trip Created", status = HttpStatusCode.Created)
        }
        delete("{id}") {
            val id = call.request.queryParameters["id"]
            id?.let {
                val deleted = tripStorage.removeIf { it.id == id }
                if (deleted) call.respondText("Trip deleted with $id", status = HttpStatusCode.Accepted)
                else call.respondText("Trip with given id not found", status = HttpStatusCode.NotFound)
            } ?: call.respondText("Missing or malformed id", status = HttpStatusCode.BadRequest)
        }
    }
}