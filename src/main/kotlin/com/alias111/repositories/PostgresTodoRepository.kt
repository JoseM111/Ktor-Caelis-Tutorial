/** PostgresTodoRepository.kt */
package com.alias111.repositories

import com.alias111.entities.TodoDraftEntity
import com.alias111.entities.TodoEntity
import database.DBTodoEntity
import database.DatabaseMgr
// ⚫️⚫️☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰

class PostgresTodoRepository: ITodoRepository {
    // : - ™PROPERTIES™
    //™━━━━━━━━━━━━━━━━━━━━━━━━━━━━
    private val database = DatabaseMgr()
    //™━━━━━━━━━━━━━━━━━━━━━━━━━━━━

    // ⚫️⚫️☰☰☰☰☰☰☰☰☰☰ members-to-implement ☰☰☰☰☰☰☰☰☰☰⚫️⚫️
    override fun repoGetAllTodos(): List<TodoEntity> {
        // ™ ____________
        return database.getAllTodos().map { with: DBTodoEntity ->
            TodoEntity(with.id, with.title, with.done)
        }
    }

    override fun repoGetTodoById(id: Int): TodoEntity? {
        TODO("Not yet implemented")
    }

    override fun repoAddTodo(todoDraft: TodoDraftEntity): TodoEntity {
        TODO("Not yet implemented")
    }

    override fun repoRemoveTodo(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun repoUpdateTodo(id: Int, todoDraft: TodoDraftEntity): Boolean {
        TODO("Not yet implemented")
    }
}
// ⚫️⚫️☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰