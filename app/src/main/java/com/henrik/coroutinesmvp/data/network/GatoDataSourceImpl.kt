package com.henrik.coroutinesmvp.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.henrik.coroutinesmvp.data.entity.Gato
import com.henrik.coroutinesmvp.internal.NoConnectivityException

class GatoDataSourceImpl(private val gatoService: GatoService) : GatoDataSource {

    private val _catDownloaded: MutableLiveData<Gato> = MutableLiveData()
    override val catDownloaded: LiveData<Gato>
        get() = _catDownloaded

    override suspend fun fetchGato() {
        try {
            val gato = gatoService.getCat().await()
            _catDownloaded.postValue(gato)
        }catch (e: NoConnectivityException){
            Log.i("Connectivity Status", "No Connectivity! ${e.printStackTrace()}")
        }
    }
}