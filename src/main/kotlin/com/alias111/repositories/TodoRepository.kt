/** TodoRepository.kt */
package com.alias111.repositories

import com.alias111.entities.TodoDraftEntity
import com.alias111.entities.TodoEntity

// ⚫️⚫️☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰
class TodoRepository : ITodoRepository {
    /// ======== <> Properties <> ========
    private val todosData: MutableList<TodoEntity> = mutableListOf<TodoEntity>()
    // ⚫️⚫️☰☰☰☰☰☰☰☰☰☰ members-to-implement ☰☰☰☰☰☰☰☰☰☰⚫️⚫️
    override fun repoGetAllTodos(): List<TodoEntity> = todosData

    override fun repoGetTodoById(id: Int): TodoEntity? {
        return todosData.firstOrNull { ifItIs: TodoEntity -> ifItIs.id == id }
    }

    override fun repoAddTodo(todoDraft: TodoDraftEntity): TodoEntity {
        // ™ ____________
        val todo = TodoEntity(
            id = todosData.size + 1,
            title = todoDraft.title,
            isDone = todoDraft.isDone,
        )

        todosData.add(todo)
        return todo
    }

    override fun repoRemoveTodo(id: Int): Boolean = todosData.removeIf { the: TodoEntity ->
        the.id == id
    }

    override fun repoUpdateTodo(id: Int, todoDraft: TodoDraftEntity): Boolean {
        // ™ ____________
        val todo: TodoEntity = todosData.firstOrNull { does: TodoEntity ->
            does.id == id
            // ™ ____________
        } ?: return false

        // update our todos
        todo.title = todoDraft.title
        todo.isDone = todoDraft.isDone

        return true
    }
}
// ⚫️⚫️☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰









