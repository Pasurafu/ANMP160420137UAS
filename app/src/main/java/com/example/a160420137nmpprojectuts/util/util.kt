import android.content.Context
import androidx.room.Room
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