import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.a160420137nmpprojectuts.model.GunplaDatabase
import com.example.a160420137nmpprojectuts.model.LoginLoginDatabase

val DB_NAME = "newgunpladb"
fun buildDb(context: Context): GunplaDatabase {
    val db = Room.databaseBuilder(context, GunplaDatabase::class.java, DB_NAME)
        .build()
    return db
}
fun buildDb2(context: Context): LoginLoginDatabase {
    val db = Room.databaseBuilder(context, LoginLoginDatabase::class.java, DB_NAME)
        .build()
    return db


}
val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "ALTER TABLE todo ADD COLUMN priority INTEGER DEFAULT 3 not null")
    }
}