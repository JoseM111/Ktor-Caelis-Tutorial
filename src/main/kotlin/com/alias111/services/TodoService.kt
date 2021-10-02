/** TodoService.kt */
package com.alias111.services

import com.alias111.entities.TodoDraftEntity
import com.alias111.entities.TodoEntity
import database.DBTodoEntity
import database.DBTodoTable
import database.DatabaseMgr
import org.ktorm.dsl.delete
import org.ktorm.dsl.eq
import org.ktorm.dsl.insertAndGenerateKey
import org.ktorm.dsl.update
import org.ktorm.entity.firstOrNull
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.toList
// ⚫️⚫️☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰

class TodoService {
    // : - ™PROPERTIES™
    //™━━━━━━━━━━━━━━━━━━━━━━━━━━━━
    private val db = DatabaseMgr()
    //™━━━━━━━━━━━━━━━━━━━━━━━━━━━━

    fun serviceGetAllTodos(): List<DBTodoEntity> {
        return db.ktormDatabase.sequenceOf(DBTodoTable).toList()
    }

    fun serviceGetTodoById(id: Int): DBTodoEntity? {
        // ™ ____________
        return db.ktormDatabase.sequenceOf(DBTodoTable)
            .firstOrNull { ifIs: DBTodoTable -> ifIs.id eq id }
    }

    fun serviceAddTodo(todoDraft: TodoDraftEntity): TodoEntity {
        // ™ ____________
        val insertedIdKey = db.ktormDatabase.insertAndGenerateKey(
            table = DBTodoTable,
            block = { _: DBTodoTable ->
                set(column = DBTodoTable.title, value = todoDraft.title)
                set(column = DBTodoTable.done, value = todoDraft.done)
            }) as Int

        return TodoEntity(
            id = insertedIdKey,
            title = todoDraft.title,
            done = todoDraft.done
        )
    }

    fun serviceUpdateTodo(id: Int, todoDraft: TodoDraftEntity): Boolean {
        // ™ ____________
        val updateRows: Int = db.ktormDatabase.update(
            table = DBTodoTable,
            block = { table: DBTodoTable ->
                set(column = DBTodoTable.title, value = todoDraft.title)
                set(column = DBTodoTable.done, value = todoDraft.done)

                where {
                    table.id eq id
                }
            }
        )

        return updateRows > 0
    }

    fun serviceRemoveTodoById(id: Int): Boolean {
        // ™ ____________
        val deletedRows: Int = db.ktormDatabase.delete(
            table = DBTodoTable,
            predicate = { table: DBTodoTable ->
                table.id eq id
            }
        )

        return deletedRows > 0
    }
}
// ⚫️⚫️☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰