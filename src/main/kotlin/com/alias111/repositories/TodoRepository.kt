/** TodoRepository.kt */
package com.alias111.repositories

import com.alias111.entities.TodoDraftEntity
import com.alias111.entities.TodoEntity

// ⚫️⚫️☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰
class TodoRepository : ITodoRepository {
    /// ======== <> Properties <> ========
    private val todosData: MutableList<TodoEntity> = mutableListOf<TodoEntity>()

    // ⚫️⚫️☰☰☰☰☰☰☰☰☰☰ members-to-implement ☰☰☰☰☰☰☰☰☰☰⚫️⚫️
    override fun repoGetAllTodos(): List<TodoEntity> {
        // ™ ____________
        return todosData
    }

    override fun repoGetTodoById(id: Int): TodoEntity? {
        return todosData.firstOrNull { ifItIs: TodoEntity -> ifItIs.id == id }
    }

    override fun repoAddTodo(todoDraft: TodoDraftEntity): TodoEntity {
        // ™ ____________
        val newTodo = TodoEntity(
            id = todosData.size + 1,
            title = todoDraft.title,
            done = todoDraft.done,
        )

        todosData.add(newTodo)
        return newTodo
    }

    override fun repoUpdateTodo(id: Int, todoDraft: TodoDraftEntity): Boolean {
        // ™ ____________
        val todo: TodoEntity = todosData.firstOrNull { doesHave: TodoEntity ->
            doesHave.id == id
            // ™ ____________
        } ?: return false

        // update our todos
        todo.title = todoDraft.title
        todo.done = todoDraft.done

        return true
    }

    override fun repoRemoveTodo(id: Int): Boolean = todosData
        .removeIf { the: TodoEntity -> the.id == id }
}
// ⚫️⚫️☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰









