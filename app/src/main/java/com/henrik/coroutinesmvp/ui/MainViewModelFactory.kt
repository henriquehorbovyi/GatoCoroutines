package com.henrik.coroutinesmvp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.henrik.coroutinesmvp.repository.GatoRepository

class MainViewModelFactory(private val gatoRepository: GatoRepository) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(gatoRepository) as T
    }
}