/** Todo.kt */
package com.alias111.models

//import kotlinx.serialization.*
// ⚫️⚫️☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰

//@Serializable
data class Todo(
    val id: Int,
    var title: String,
    var done: Boolean,
)

val TODO_DUMMY_DATA: List<Todo> = listOf<Todo>(
    Todo(id = 1, title = "Code", done = true),
    Todo(id = 2, title = "Drive uber", done = false),
    Todo(id = 3, title = "Call Wife", done = false),
    Todo(id = 4, title = "Go to bed early", done = false),
)
// ⚫️⚫️☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰
