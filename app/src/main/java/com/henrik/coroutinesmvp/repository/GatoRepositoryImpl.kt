package com.henrik.coroutinesmvp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.henrik.coroutinesmvp.data.entity.Gato
import com.henrik.coroutinesmvp.data.network.GatoDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GatoRepositoryImpl(
    private val dataSource: GatoDataSource
) : GatoRepository {

    override suspend fun getGato(): LiveData<out Gato> {
        return withContext(Dispatchers.IO){
            return@withContext dataSource.catDownloaded
        }
    }

    override suspend fun fetchGato() {
        Log.i("fetching", "loading")
        dataSource.fetchGato()
    }
}