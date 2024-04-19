package com.example.a160420137nmpprojectuts.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.a160420137nmpprojectuts.model.Gunpla
import com.example.a160420137nmpprojectuts.view.GunplaAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.squareup.picasso.Picasso

class ListViewModel(application: Application): AndroidViewModel(application)
 {
    val gunplaLD = MutableLiveData<ArrayList<Gunpla>>()
    val gunplaLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null


    fun refresh() {


        gunplaLoadErrorLD.value = false
        loadingLD.value = true
        queue = Volley.newRequestQueue(getApplication() )


        val url = "http://10.0.2.2/gunpla/gunpla.json"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<List<Gunpla>>() { }.type
                val result = Gson().fromJson<List<Gunpla>>(it, sType)
                gunplaLD.value = result as ArrayList<Gunpla>?

                loadingLD.value = false
                Log.d("showvoley", result.toString())
            },
            {
                Log.d("showvoley", it.toString())
                gunplaLoadErrorLD.value = false
                loadingLD.value = false
            },




        )
        stringRequest.tag = TAG
        queue?.add(stringRequest)


    }
     override fun onCleared() {
         super.onCleared()
         queue?.cancelAll(TAG)
     }




 }