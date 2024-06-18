package com.example.a160420137nmpprojectuts.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
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

    fun addTodo(list: List<LoginLogin>) {
        launch {
            val db = LoginLoginDatabase.buildDatabase(
                getApplication()
            )
            db.LoginLoginDao().insertAll(*list.toTypedArray())
        }
    }
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO


}
