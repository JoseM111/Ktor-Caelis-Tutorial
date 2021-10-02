/** MySqlTodoRepository.kt */
package com.alias111.repositories

import com.alias111.entities.TodoDraftEntity
import com.alias111.entities.TodoEntity
import com.alias111.services.TodoService
import database.DBTodoEntity
// ⚫️⚫️☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰

class MySqlTodoRepository: ITodoRepository {
    // : - ™PROPERTIES™
    //™━━━━━━━━━━━━━━━━━━━━━━━━━━━━
//    private val todoService = TodoService()
    private val todoService = TodoService()
    //™━━━━━━━━━━━━━━━━━━━━━━━━━━━━

    // ⚫️⚫️☰☰☰☰☰☰☰☰☰☰ members-to-implement ☰☰☰☰☰☰☰☰☰☰⚫️⚫️
    override fun repoGetAllTodos(): List<TodoEntity> {
        // ™ ____________
        return todoService.serviceGetAllTodos().map { with: DBTodoEntity ->
            TodoEntity(with.id, with.title, with.done)
        }
    }

    override fun repoGetTodoById(id: Int): TodoEntity? {
        // ™ ____________
        /** @let: can be used to invoke one or more functions on
         *  results of call chains. the `?` is to check that the
         *  chain is not null, if it is then it will return an error*/
        return todoService.serviceGetTodoById(id = id)
            ?.let { newTodo: DBTodoEntity ->
                TodoEntity(
                    id = newTodo.id,
                    title = newTodo.title,
                    done = newTodo.done
                )
            }
    }

    override fun repoAddTodo(todoDraft: TodoDraftEntity): TodoEntity {
        return todoService.serviceAddTodo(todoDraft = todoDraft)
    }

    override fun repoUpdateTodo(id: Int, todoDraft: TodoDraftEntity): Boolean {
        return todoService.serviceUpdateTodo(id = id, todoDraft = todoDraft)
    }

    override fun repoRemoveTodo(id: Int): Boolean {
        return todoService.serviceRemoveTodoById(id = id)
    }
}
// ⚫️⚫️☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰