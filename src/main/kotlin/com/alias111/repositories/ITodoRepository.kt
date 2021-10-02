/** ITodoRepository.kt */
package com.alias111.repositories

import com.alias111.entities.TodoDraftEntity
import com.alias111.entities.TodoEntity
// ⚫️⚫️☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰

interface ITodoRepository {
    // ⚫️⚫️☰☰☰☰☰☰☰☰☰☰ contract to-implement ☰☰☰☰☰☰☰☰☰☰⚫️⚫️
    fun repoGetAllTodos(): List<TodoEntity>

    fun repoGetTodoById(id: Int): TodoEntity?

    fun repoAddTodo(todoDraft: TodoDraftEntity): TodoEntity

    fun repoUpdateTodo(id: Int, todoDraft: TodoDraftEntity): Boolean

    fun repoRemoveTodo(id: Int): Boolean
}
// ⚫️⚫️☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰