/** database.DatabaseMgr.kt */
package database

import org.ktorm.database.Database
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
    internal val ktormDatabase: Database
    //™━━━━━━━━━━━━━━━━━━━━━━━━━━━━

    init {
        val JDBC_URL: String = "jdbc:mysql://$hostname:3306/$dbname?user=$username&password=$password&useSSL=false"

        ktormDatabase = Database.connect(JDBC_URL)
    }
}
// ⚫️⚫️☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰


















