package database

/** database.DatabaseMgr.kt */
import org.ktorm.database.Database
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.toList

// ⚫️⚫️☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰

class DatabaseMgr {
    // : - ™PROPERTIES CONFIGURATION™
    //™━━━━━━━━━━━━━━━━━━━━━━━━━━━━
    private val hostname = "localhost"
    private val dbname = "ktor_todo"
     private val username = "root"
     private val password = "alias111"
    //™━━━━━━━━━━━━━━━━━━━━━━━━━━━━

    // : - ™PROPERTIES DATABASE™
    //™━━━━━━━━━━━━━━━━━━━━━━━━━━━━
    private val ktormDatabase: Database
    //™━━━━━━━━━━━━━━━━━━━━━━━━━━━━

    init {
        val JDBC_URL = "jdbc:mysql://$hostname:3306/$dbname?user=$username&password=$password&useSSL=false"
        ktormDatabase = Database.connect(JDBC_URL)
    }

    fun getAllTodos(): List<DBTodoEntity> {
        return ktormDatabase.sequenceOf(DBTodoTable).toList()
    }
}
// ⚫️⚫️☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰