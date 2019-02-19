package com.henrik.coroutinesmvp.ui

import androidx.lifecycle.ViewModel
import com.henrik.coroutinesmvp.internal.lazyDeferred
import com.henrik.coroutinesmvp.repository.GatoRepository
import kotlinx.coroutines.*

class MainViewModel(private val repository: GatoRepository) : ViewModel(){

    val background = Job() + Dispatchers.IO

    val gato by lazyDeferred {
        repository.getGato()
    }

    fun fetch() = CoroutineScope(background).launch{
        repository.fetchGato()
    }

}


