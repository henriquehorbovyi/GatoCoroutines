package com.henrik.coroutinesmvp

import android.app.Application
import org.koin.android.ext.android.startKoin

class GatoApp : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(AppModule.modules))
    }

}