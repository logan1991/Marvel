package com.oskarszymczyk.core.rest

import com.oskarszymczyk.core.rest.NetworkManager.DIGEST_FORMAT
import com.oskarszymczyk.core.rest.NetworkManager.MD5
import com.oskarszymczyk.core.rest.NetworkManager.SEPARATOR
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
    const val MD5 = "MD5"
    const val SEPARATOR = ""
    const val DIGEST_FORMAT = "%02x"

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
                    .baseUrl(CoreConst.BASE_URL)
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
                            val hash = StringBuilder(timeStamp + CoreConst.PRIVATE_API_KEY + CoreConst.PUBLIC_API_KEY).toString().md5()
                            val url = request.url().newBuilder()
                                    .addQueryParameter(CoreConst.QUERY_TS, timeStamp)
                                    .addQueryParameter(CoreConst.QUERY_API_HEY, CoreConst.PUBLIC_API_KEY)
                                    .addQueryParameter(CoreConst.QUERY_HASH, hash)
                                    .build()
                            request = request.newBuilder().url(url).build()
                            return chain.proceed(request)
                        }

                    })
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build()
}

fun String.md5(): String {
    val md = MessageDigest.getInstance(MD5)
    val digested = md.digest(toByteArray())
    return digested.joinToString(SEPARATOR) {
        String.format(DIGEST_FORMAT, it)
    }
}