package com.example.a160420137nmpprojectuts.model

import com.google.gson.annotations.SerializedName

data class Gunpla(
    var id:String?,
    @SerializedName("gunpla_name")
    var name:String?,
    @SerializedName("gunpla_desc")
    var desc:String?,
    @SerializedName("image_url")
    var imageUrl:String?
)
