/** Routing.kt */
package com.alias111.plugins

import com.alias111.models.TODO_DUMMY_DATA
import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.response.*
//import io.ktor.serialization.*
//import kotlinx.serialization.json.Json

// ⚫️⚫️☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰

fun Application.configureRouting() {
    // ™ ____________
    jsonOutputConfig()
    // Starting point for a Ktor app:
    routing {
        // ™ ____________
        get(path = "/") {
            call.respondText("Hello World!")
        }

        get(path = "/todos") {
            call.respond(TODO_DUMMY_DATA)
        }

        get(path = "/todos/{id}") {
            val id: String? = call.parameters["id"]
            call.respondText("*. [ GET ] Todolist details for todo item by id: #$id")
        }

        post(path = "/todos") {

        }

        put(path = "/todos/{id}") {

        }

        delete(path = "/todos/{id}") {

        }
    }
}
// ⚫️⚫️☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰

private fun Application.jsonOutputConfig() {
    // ™ ____________
    install(CallLogging)
    install(ContentNegotiation) {
        // ™ ____________
         gson {
             setPrettyPrinting()
             disableHtmlEscaping()
         }
//        json(Json {
//            prettyPrint = true
//            isLenient = true
//        })
    }
}
// ⚫️⚫️☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰