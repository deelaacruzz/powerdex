package com.example.powerdex.base

import android.app.Application
import android.content.Context
import com.example.powerdex.data.api.SuperHeroService
import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext

class DroidApp : Application() {


    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {

        lateinit var instance: DroidApp
            private set
        private val baseUrl = "https://superheroapi.com/api/5030577660329302/"

        fun applicationContext(): Context {
            return instance.applicationContext
        }



        private fun clientOkHttp(): OkHttpClient {
            val httpLoggingInterceptor =
                HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            return OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .connectionSpecs(listOf(ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT))
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .build()

        }


        fun getRetrofitSuperhero(): SuperHeroService {
            val retrofit = Retrofit.Builder()
                .client(clientOkHttp())
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(SuperHeroService::class.java)
        }
    }
}