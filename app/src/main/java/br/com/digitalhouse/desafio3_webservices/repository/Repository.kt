package br.com.digitalhouse.desafio3_webservices.repository

import br.com.digitalhouse.desafio3_webservices.comicsHQ.Comics
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    @GET("comics?ts=1&apikey=6eb7e8896ec5850c52515a8a23ee97f0&hash=40a3aa568bb269dfad85ae0c4a297181")
    suspend fun getAllHQRepo(
        @Query("offset") offset: Int
    ) : Comics
}


val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://gateway.marvel.com:443/v1/public/characters/1009610/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val serv: Service = retrofit.create(Service::class.java)