package ru.ponomarevss.rickandmortyapi.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.ponomarevss.rickandmortyapi.mvp.model.api.IDataSource
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiModule {

    @Named("baseUrl")
    @Provides
    @Singleton
    fun baseUrl(): String = "https://rickandmortyapi.com/api/"

    @Provides
    @Singleton
    fun gson(): Gson = GsonBuilder()
        .excludeFieldsWithoutExposeAnnotation()
        .create()

    @Provides
    @Singleton
    fun api(@Named("baseUrl") baseUrl: String, gson: Gson) : IDataSource = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(IDataSource::class.java)
}