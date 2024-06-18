package com.example.a160420137nmpprojectuts.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = arrayOf(LoginLogin::class), version =  1)
abstract class GunplaDatabase: RoomDatabase() {
    abstract fun GunplaDao(): GunplaDao

    companion object {@Volatile private var instance: GunplaDatabase ?= null
        private val LOCK = Any()

        fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                 GunplaDatabase::class.java,
                "newgunpladb").build()

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

