package com.henrik.coroutinesmvp.data.network

import androidx.lifecycle.LiveData
import com.henrik.coroutinesmvp.data.entity.Gato

interface GatoDataSource {
    val catDownloaded: LiveData<Gato>
    suspend fun fetchGato()
}