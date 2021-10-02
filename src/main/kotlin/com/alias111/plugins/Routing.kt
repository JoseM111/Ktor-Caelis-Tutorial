/** Routing.kt */
package com.alias111.plugins

import com.alias111.entities.TodoDraftEntity
import com.alias111.entities.TodoEntity
import com.alias111.repositories.ITodoRepository
import com.alias111.repositories.MySqlTodoRepository
import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*

//import io.ktor.serialization.*
//import kotlinx.serialization.json.Json
// ⚫️⚫️☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰
fun Application.configureRouting(): Unit {
    // ™ ____________
    val todoRepo: ITodoRepository = MySqlTodoRepository()

    jsonOutputConfig()
    // ⚫️⚫️☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰
    // Starting point for a Ktor app:
    routing {
        // ™ ____________
        /** @GET: request home route  |*/
        get(path = "/") {
            call.respondText("[HOME ROUTE]")
        }

        /** @GET: request: get all todos  |*/
        get(path = "/todos") {
            call.respond(todoRepo.repoGetAllTodos())
        }

        /** @GET: request: get todos by id  |*/
        get(path = "/todos/{id}") {
            val id: Int? = call.parameters["id"]?.toIntOrNull()
            // checking id for null
            if (id == null) {
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
            val todo: TodoEntity? = todoRepo.repoGetTodoById(id = id)

            when (todo) {
                // ™ ____________
                null -> call.respond(HttpStatusCode.NotFound,
                    message = "[ ERROR ]..todo not found for id: ( #$id ).."
                )
                // ™ ____________
                else -> call.respond(todo)
            }

            println("*. [ GET ] Todos: $todo")
        }

        /** @POST: request: post todos |*/
        post(path = "/todos") {
            // ™ ____________
            val todoDraft: TodoDraftEntity = call.receive<TodoDraftEntity>()
            val newTodo: TodoEntity = todoRepo.repoAddTodo(todoDraft = todoDraft)

            call.respond(newTodo)
        }

        /** @PUT: request: put todos by id  |*/
        put(path = "/todos/{id}") {
            // ™ ____________
            // acts as @Body in other frameworks
            val todoDraft: TodoDraftEntity = call.receive<TodoDraftEntity>()
            val todoId: Int? = call.parameters["id"]?.toIntOrNull()

            if (todoId == null) {
                call.respond(
                    HttpStatusCode.BadRequest,
                    message = "[ ERROR ]..Invalid id parameter. Has to be a number..."
                )

                return@put
            }
            val todoIsUpdated: Boolean = todoRepo.repoUpdateTodo(
                id = todoId,
                todoDraft = todoDraft
            )

            when {
                todoIsUpdated -> call.respond(
                    HttpStatusCode.OK,
                    message = "[ SUCCESS ]..successfully updated todo: $todoDraft"
                )
                // ™ ____________
                else -> call.respond(
                    HttpStatusCode.NotFound,
                    message = "[ ERROR ]..could not find todo with the id of: #$todoId"
                )
                // ™ ____________
            }
        }

        /** @DELETE: request: deletes todos by id |*/
        delete(path = "/todos/{id}") {
            // ™ ____________
            val todoId: Int? = call.parameters["id"]?.toIntOrNull()

            if (todoId == null) {
                call.respond(
                    HttpStatusCode.BadRequest,
                    message = "[ ERROR ]..Invalid id parameter. Has to be a number..."
                )

                return@delete
            }

            val hasRemovedTodo: Boolean = todoRepo.repoRemoveTodo(id = todoId)

            when {
                hasRemovedTodo -> call.respond(
                    HttpStatusCode.OK,
                    message = "[ SUCCESS ]..successfully removed todo..."
                )
                // ™ ____________
                else -> call.respond(
                    HttpStatusCode.NotFound,
                    message = "[ ERROR ]..could not find todo with the id of: #$todoId"
                )
                // ™ ____________
            }
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