/** Routing.kt */
package com.alias111.plugins

import com.alias111.entities.TodoEntity
import com.alias111.repositories.TodoRepository
import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.http.*
import io.ktor.response.*
//import io.ktor.serialization.*
//import kotlinx.serialization.json.Json
// ⚫️⚫️☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰

fun Application.configureRouting(): Unit {
    // ™ ____________
    val todoRepo = TodoRepository()

    jsonOutputConfig()
    // ⚫️⚫️☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰

    // Starting point for a Ktor app:
    routing {
        // ™ ____________
        /** @GET: request home route  |*/
        get(path = "/") {
            call.respondText("Hello World!")
        }
        /** @GET: request: get all todos  |*/
        get(path = "/todos") {
            call.respond(todoRepo.repoGetAllTodos())
        }
        /** @GET: request: get todos by id  |*/
        get(path = "/todos/{id}") {
            val id: Int? = call.parameters["id"]?.toIntOrNull()

            // checking id for null
            if(id == null) {
                //..........
                call.respond(
                    HttpStatusCode.BadRequest,
                    message = "[ ERROR ]..Invalid id parameter. Has to be a number..."
                )

                /** @return@funcName:
                 *  tells from which function to return from. Great for lambdas */
                return@get
            }

            // `id` already casted: Smart cast to kotlin.Int (for null call)
            // checking `todos` for null
            val todo: TodoEntity? = todoRepo.repoGetTodoById(id)

            when (todo) {
                // ™ ____________
                null -> call.respond(HttpStatusCode.NotFound,
                    message = "[ ERROR ]..TodoEntity not found for id: #$id.."
                )
                // ™ ____________
                else -> call.respond(todo)
            }

            println("*. [ GET ] Todos: $todo")
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