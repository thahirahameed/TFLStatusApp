package com.example.tflstatusapp.di

import com.example.tflstatusapp.data.TubeLinesApi
import com.example.tflstatusapp.data.repo.TubeLineRepositoryImpl
import com.example.tflstatusapp.domain.repo.TubeLineRepository
import com.example.tflstatusapp.util.Constants.BASE_URL
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideGson(): Gson{
        return Gson()
    }

    private val okHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        })
        .build()


    @Provides
    fun providesRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl(BASE_URL)
        .build()


    @Provides
    fun provideShowsApi(retrofit: Retrofit): TubeLinesApi = retrofit.create(TubeLinesApi::class.java)

    @Provides
    @Singleton
    fun providesTubeLineRepository(tubeLinesApi: TubeLinesApi): TubeLineRepository{
        return TubeLineRepositoryImpl(tubeLinesApi)
    }
}