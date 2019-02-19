package com.henrik.coroutinesmvp

import com.henrik.coroutinesmvp.data.network.*
import com.henrik.coroutinesmvp.repository.GatoRepository
import com.henrik.coroutinesmvp.repository.GatoRepositoryImpl
import com.henrik.coroutinesmvp.ui.MainViewModel
import com.henrik.coroutinesmvp.ui.MainViewModelFactory
import org.koin.dsl.module.module

object AppModule {
    val modules = module{
        factory <ConnectivityInterface> { ConnectivityInterfaceImpl(get()) }
        factory { GatoService(get()) }
        factory <GatoDataSource> { GatoDataSourceImpl(get()) }
        factory<GatoRepository> { GatoRepositoryImpl(get()) }
        factory { MainViewModelFactory(get()) }
    }
}