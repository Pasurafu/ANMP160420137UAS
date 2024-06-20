package com.example.a160420137nmpprojectuts.model
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
@Dao

interface LoginLoginDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg loginLogin:LoginLogin)

    @Query("SELECT * FROM loginlogin")
    fun selectAllLoginLogin(): List<LoginLogin>

    @Query("SELECT * FROM loginlogin WHERE uuid= :id")
    fun selectLoginLogin(id:Int): LoginLogin


    @Delete
    fun deleteLoginLogin(loginLogin:LoginLogin)
    @Query("UPDATE loginlogin SET username=:username, password=:password,email=:email, namaDepan=:namaDepan,namaBelakang=:namaBelakang WHERE uuid = :id")
            suspend fun update(username:String, password:String,email:String,namaDepan:String,namaBelakang:String , id:Int)



}