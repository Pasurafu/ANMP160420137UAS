package com.example.a160420137nmpprojectuts.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity

data class LoginLogin(
    @ColumnInfo(name="username")

    var username:String,
    @ColumnInfo(name="password")
    var password:String,
    @ColumnInfo(name="email")
    var email:String,
    @ColumnInfo(name="namaDepan")
    var namaDepan:String,
    @ColumnInfo(name="namaBelakang")
    var namaBelakang:String){
    @PrimaryKey(autoGenerate = true)
    var uuid:Int =0
}

@Entity
data class Gunpla(
    @ColumnInfo(name="id")
    var id:String,
    @ColumnInfo(name="name")
    var name:String,
    @ColumnInfo(name="desc")
    var desc:String,
    @ColumnInfo(name="url")
    var imageUrl:String
){
    @PrimaryKey(autoGenerate = true)
    var uuid:Int =0
}
