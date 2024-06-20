package com.example.a160420137nmpprojectuts.model

import DB_NAME
import MIGRATION_1_2
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = arrayOf(LoginLogin::class), version =  2)
abstract class GunplaDatabase: RoomDatabase() {
    abstract fun GunplaDao(): GunplaDao

    companion object {@Volatile private var instance: GunplaDatabase ?= null
        private val LOCK = Any()

      private  fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                 GunplaDatabase::class.java,
                "newgunpladb").addMigrations(MIGRATION_1_2)
                .build()
        fun buildDb(context: Context):GunplaDatabase {
            val db = Room.databaseBuilder(context,
                GunplaDatabase::class.java, DB_NAME)
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

