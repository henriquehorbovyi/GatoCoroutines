package com.henrik.coroutinesmvp.data.network

import com.henrik.coroutinesmvp.data.entity.Gato
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


interface GatoService {
    @GET("meow")
    fun getCat(): Deferred<Gato>

    companion object {
        private const val BASE_URL = "https://aws.random.cat/"
        operator fun invoke(connectivityInterface: ConnectivityInterface): GatoService {
            val okHttpClient =
                OkHttpClient.Builder()
                    .addInterceptor(connectivityInterface)
                    .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GatoService::class.java)
        }
    }


}