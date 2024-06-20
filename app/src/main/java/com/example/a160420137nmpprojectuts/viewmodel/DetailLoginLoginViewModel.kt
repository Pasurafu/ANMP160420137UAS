package com.example.a160420137nmpprojectuts.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import buildDb
import buildDb2
import com.example.a160420137nmpprojectuts.model.Gunpla
import com.example.a160420137nmpprojectuts.model.GunplaDatabase
import com.example.a160420137nmpprojectuts.model.LoginLogin
import com.example.a160420137nmpprojectuts.model.LoginLoginDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DetailLoginLoginViewModel(application: Application)
    : AndroidViewModel(application), CoroutineScope {
    private val job = Job()

    fun addLoginLogin(list: List<LoginLogin>) {
        launch {
            val db = buildDb2(getApplication())
            db.LoginLoginDao().insertAll(*list.toTypedArray())
        }
    }
    fun update(username:String, password:String,email:String,namaDepan:String,namaBelakang:String , id:Int) {
        launch {
            val db = buildDb2(getApplication())
            db.LoginLoginDao().update(username, password, email,namaDepan,namaBelakang, id)
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO


}
val LoginLoginLD = MutableLiveData<LoginLogin>()

