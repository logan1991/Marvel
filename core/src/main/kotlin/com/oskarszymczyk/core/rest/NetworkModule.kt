package com.oskarszymczyk.core.rest

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import com.oskarszymczyk.core.rest.interceptors.AuthenticationInterceptor
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@Suppress("unused")
class NetworkModule {

    @Provides
    @Singleton
    fun provideMarvelService(retrofit: Retrofit) =
            retrofit.create(NetworkService::class.java)


    @Provides
    fun provideNetworkInterface(okHttpClient: OkHttpClient, moshi: Moshi) =
            Retrofit.Builder()
                    .baseUrl(CoreConst.BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create(moshi))
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .client(okHttpClient)
                    .build()

    @Provides
    fun provideOkHttpClient() =
            OkHttpClient.Builder()
                    .addInterceptor(AuthenticationInterceptor())
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build()

    @Provides
    fun provideMoshi() =
            Moshi.Builder().build()

}

