package com.oskarszymczyk.marvel.rest

import com.oskarszymczyk.marvel.AppConsts
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.security.MessageDigest

@Module
@Suppress("unused")
object NetworkManager {

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideMarvelService(retrofit: Retrofit) =
            retrofit.create(NetworkService::class.java)


    @Provides
    @Reusable
    @JvmStatic
    internal fun provideNetworkInterface(okHttpClient: OkHttpClient) =
            Retrofit.Builder()
                    .baseUrl(AppConsts.BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .client(okHttpClient)
                    .build()

    @Provides
    @Reusable
    @JvmStatic
    internal fun profiveOkHttpClient() =
            OkHttpClient.Builder()
                    .addInterceptor(object : Interceptor {
                        override fun intercept(chain: Interceptor.Chain): Response {
                            var request = chain.request()
                            val timeStamp = System.currentTimeMillis().toString();
                            val hash = StringBuilder(timeStamp + AppConsts.PRIVATE_API_KEY + AppConsts.PUBLIC_API_KEY).toString().md5()
                            val url = request.url().newBuilder()
                                    .addQueryParameter(AppConsts.QUERY_TS, timeStamp)
                                    .addQueryParameter(AppConsts.QUERY_API_HEY, AppConsts.PUBLIC_API_KEY)
                                    .addQueryParameter(AppConsts.QUERY_HASH, hash)
                                    .build()
                            request = request.newBuilder().url(url).build()
                            return chain.proceed(request)
                        }

                    })
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build()
}

fun String.md5(): String {
    val md = MessageDigest.getInstance("MD5")
    val digested = md.digest(toByteArray())
    return digested.joinToString("") {
        String.format("%02x", it)
    }
}