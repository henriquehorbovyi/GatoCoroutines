package com.henrik.coroutinesmvp.repository

import androidx.lifecycle.LiveData
import com.henrik.coroutinesmvp.data.entity.Gato

interface GatoRepository {
    suspend fun getGato(): LiveData<out Gato>
    suspend fun fetchGato()
}