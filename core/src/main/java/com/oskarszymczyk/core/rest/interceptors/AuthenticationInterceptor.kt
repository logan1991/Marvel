package com.oskarszymczyk.core.rest.interceptors

import com.oskarszymczyk.core.rest.CoreConst
import okhttp3.Interceptor
import okhttp3.Response

class AuthenticationInterceptor : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val timeStamp = System.currentTimeMillis().toString();
        val url = request.url().newBuilder()
                .addQueryParameter(CoreConst.QUERY_TS, timeStamp)
                .addQueryParameter(CoreConst.QUERY_API_HEY, CoreConst.PUBLIC_API_KEY)
                .addQueryParameter(CoreConst.QUERY_HASH, CoreConst.convertToMd5(timeStamp))
                .build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }


}