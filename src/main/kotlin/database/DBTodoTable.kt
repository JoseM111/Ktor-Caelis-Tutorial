/** DBTodoTable.kt */
package database

import org.ktorm.entity.Entity
import org.ktorm.schema.*
// ⚫️⚫️☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰


object DBTodoTable: Table<DBTodoEntity>(tableName = "todo") {
    // ™ ____________
    val id: Column<Int> = int(name = "id")
        .primaryKey().bindTo { bindTo: DBTodoEntity -> bindTo.id }

    val title: Column<String> = varchar(name = "title")
        .bindTo { bindTo: DBTodoEntity -> bindTo.title }

    val done: Column<Boolean> = boolean(name = "done")
        .bindTo { bindTo: DBTodoEntity -> bindTo.done }
}
// ⚫️⚫️☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰

interface DBTodoEntity: Entity<DBTodoEntity> {
    // ™ ____________
    companion object: Entity.Factory<DBTodoEntity>()

    val id: Int
    val title: String
    val done: Boolean
}
// ⚫️⚫️☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰