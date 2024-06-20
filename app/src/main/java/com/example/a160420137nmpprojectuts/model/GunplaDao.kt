package com.example.a160420137nmpprojectuts.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GunplaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg todo:Gunpla)

    @Query("SELECT * FROM gunpla")
    fun selectAllGunpla(): List<Gunpla>

    @Query(value = "SELECT * FROM gunpla WHERE uuid= :id")
    fun selectGunpla(id:Int): Gunpla

    @Delete
    fun deleteGunpla(todo:Gunpla)
    @Query("UPDATE gunpla SET name=:name, descr=:desc, url=:url WHERE uuid = :id")
            suspend fun update(name:String, desc:String,url:String , id:Int)

}
