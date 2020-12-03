package br.com.digitalhouse.desafio3_webservices.repository

import br.com.digitalhouse.desafio3_webservices.comicsHQ.Comics
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Repository {

    @GET("comics?ts=1&orderBy=-focDate&apikey=de99d1f85bca19d7f67799a145912104&hash=b2f3a542ff1d531011ebaf6da5efc591")
    suspend fun getAllHQRepo(
        @Query("offset") offset: Int
    ) : Comics
}


val retrofit = Retrofit.Builder()
    .baseUrl("https://gateway.marvel.com:443/v1/public/characters/1009610/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val repo: Repository = retrofit.create(Repository::class.java)