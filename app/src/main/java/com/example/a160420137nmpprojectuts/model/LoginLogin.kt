import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "advanceu.db"
        private const val TABLE_LOGIN = "simplelogintable"
        private const val TABLE_RETYPE_PASSWORD = "retypepasswordkeeper"

        // Login table columns
        private const val COLUMN_ID = "id"
        private const val COLUMN_USERNAME = "username"
        private const val COLUMN_PASSWORD = "password"
        private const val COLUMN_EMAIL = "email"
        private const val COLUMN_FIRST_NAME = "first_name"
        private const val COLUMN_LAST_NAME = "last_name"

        // Retype Password table columns
        private const val COLUMN_RETYPE_PASSWORD = "retype_password"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createLoginTable = ("CREATE TABLE $TABLE_LOGIN ("
                + "$COLUMN_ID INTEGER PRIMARY KEY,"
                + "$COLUMN_USERNAME TEXT,"
                + "$COLUMN_PASSWORD TEXT,"
                + "$COLUMN_EMAIL TEXT,"
                + "$COLUMN_FIRST_NAME TEXT,"
                + "$COLUMN_LAST_NAME TEXT)")

        val createRetypePasswordTable = ("CREATE TABLE $TABLE_RETYPE_PASSWORD ("
                + "$COLUMN_ID INTEGER PRIMARY KEY,"
                + "$COLUMN_RETYPE_PASSWORD TEXT)")

        db.execSQL(createLoginTable)
        db.execSQL(createRetypePasswordTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_LOGIN")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_RETYPE_PASSWORD")
        onCreate(db)
    }

    // Add user credentials to the login table
    fun addUser(username: String, password: String, email: String, firstName: String, lastName: String): Long {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_USERNAME, username)
        values.put(COLUMN_PASSWORD, password)
        values.put(COLUMN_EMAIL, email)
        values.put(COLUMN_FIRST_NAME, firstName)
        values.put(COLUMN_LAST_NAME, lastName)

        // Inserting Row
        val id = db.insert(TABLE_LOGIN, null, values)
        db.close() // Closing database connection
        return id
    }

    // Add retype password to the retype password table
    fun addRetypePassword(retypePassword: String): Long {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_RETYPE_PASSWORD, retypePassword)

        // Inserting Row
        val id = db.insert(TABLE_RETYPE_PASSWORD, null, values)
        db.close() // Closing database connection
        return id
    }
}
