package com.oskarszymczyk.core.rest

import com.oskarszymczyk.core.rest.interceptors.AuthenticationInterceptor
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
    fun provideNetworkInterface(okHttpClient: OkHttpClient) =
            Retrofit.Builder()
                    .baseUrl(CoreConst.BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .client(okHttpClient)
                    .build()

    @Provides
    fun profiveOkHttpClient() =
            OkHttpClient.Builder()
                    .addInterceptor(AuthenticationInterceptor())
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build()


}

