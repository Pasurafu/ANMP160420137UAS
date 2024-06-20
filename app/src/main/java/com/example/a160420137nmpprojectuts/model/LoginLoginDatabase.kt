package com.example.a160420137nmpprojectuts.model

import DB_NAME
import MIGRATION_1_2
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = arrayOf(LoginLogin::class), version =  2)
abstract class LoginLoginDatabase: RoomDatabase() {
    abstract fun LoginLoginDao(): LoginLoginDao

    companion object {@Volatile private var instance: LoginLoginDatabase ?= null
        private val LOCK = Any()

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                 LoginLoginDatabase::class.java,
                "newloginlogindb").addMigrations(MIGRATION_1_2)
                .build()
        fun buildDb(context: Context):LoginLoginDatabase {
            val db = Room.databaseBuilder(context,
                LoginLoginDatabase::class.java, DB_NAME)
                .addMigrations(MIGRATION_1_2)
                .build()

            return db
        }
    }
    operator fun invoke(context:Context) {
        if(instance!=null) {
            synchronized(LOCK) {
                val any = instance ?: buildDatabase(context).also {
                    instance = it
                }

            }
        }
    }


}

