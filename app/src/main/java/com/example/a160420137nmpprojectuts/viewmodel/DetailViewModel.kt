package com.example.a160420137nmpprojectuts.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import buildDb
import com.example.a160420137nmpprojectuts.model.Gunpla
import com.example.a160420137nmpprojectuts.model.GunplaDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DetailViewModel(application: Application)
    : AndroidViewModel(application), CoroutineScope {
    private val job = Job()

    fun addGunpla(list: List<Gunpla>) {
        launch {
            val db = buildDb(getApplication())
            db.GunplaDao().insertAll(*list.toTypedArray())
        }
    }
    fun update(name:String, descr:String,url:String , id:Int) {
        launch {
            val db = buildDb(getApplication())
            db.GunplaDao().update(name, descr, url, id)
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO


}
val GunplaLD = MutableLiveData<Gunpla>()
