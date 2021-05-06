package com.example.redditassessment.model.network

import com.example.redditassessment.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {

    fun getApi(): ResponseApi{
        return Retrofit.Builder()
            .client(getClient())
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(getConverterFactory())
            .build()
            .create(ResponseApi::class.java)
    }

    private fun getConverterFactory(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    private fun getClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(
            getHttpLoggingInterceptor()
        ).build()
    }

    private fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }
    }

    companion object{
        private var INSTANCE: Network? = null

        fun getInstance(): Network {
            return synchronized(this){
                var temp = INSTANCE
                if(temp != null) return temp

                temp = Network()
                INSTANCE = temp
                return temp
            }
        }
    }
}