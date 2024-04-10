package com.example.a160420137nmpprojectuts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a160420137nmpprojectuts.model.Gunpla

class ListViewModel: ViewModel() {
    val gunplaLD = MutableLiveData<ArrayList<Gunpla>>()
    val gunplaLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    fun refresh() {
        gunplaLD.value = arrayListOf(
            Gunpla(
                "01",
                "[HG] RX-0 UNICORN GUNDAM [DESTROY MODE]",
                "Bandai 2009 High Grade\n" +
                    "Skala 1/144\n" +
                    "Series: Mobile Suit Gundam Unicorn",
                "https://i0.wp.com/gundamnesia.com/wp-content/uploads/2016/10/474e9813ebbd5e6fcbadfc1a10363593.jpg?fit=640%2C640&ssl=1"),
            Gunpla(
                "02",
                "Figure-rise Standard Uma Musume Pretty Derby Special Week",
                "Figure-rise Standard Uma Musume: Pretty Derby - Special Week\n" +
                        "\n" +
                        "Original Bandai",
                "https://images.tokopedia.net/img/cache/900/VqbcmM/2023/6/22/d57b1620-5244-47d9-8de4-fc51b5a6215e.jpg"),
            Gunpla(
                "03",
                "30MS Tokai Teio",
                "Produksi : Bandai Spirits\n" +
                        "Original : 30 MINUTES SISTERS",
                "https://images.tokopedia.net/img/cache/900/VqbcmM/2023/9/25/19b68f9d-526c-4b13-b877-571fceb84431.jpg")
        )

        gunplaLoadErrorLD.value = false
        loadingLD.value = false
    }

}