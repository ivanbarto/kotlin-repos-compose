package com.ivanbartolelli.kotlinreposcompose

import com.google.gson.GsonBuilder
import com.ivanbartolelli.kotlinreposcompose.features.repositories.data.datasources.remote.services.RepositoriesService
import kotlinx.coroutines.test.runTest
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.Test

import org.junit.Assert.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ServiceTest {

    @Test
    fun webService_isWorking() = runTest {
        val itemsPerPage = 30
        val service = provideAuthenticationService(
            provideRetrofitClient(
                provideOkHttpClient()
            )
        )

        val repositories = service.getRepositoriesByLanguage(
            language = "language:kotlin",
            page = 1,
            itemsPerPage = itemsPerPage
        )

        assertEquals(itemsPerPage, repositories.items.count())
    }

    private fun provideOkHttpClient(): OkHttpClient {

        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .readTimeout(BuildConfig.READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(BuildConfig.WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .connectTimeout(BuildConfig.CONNECT_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .build()
    }

    private fun provideRetrofitClient(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_API_URL)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().create()
                )
            )
            .client(client)
            .build()
    }

    private fun provideAuthenticationService(retrofit: Retrofit): RepositoriesService {
        return retrofit.create(RepositoriesService::class.java)
    }

}