package br.com.digitalhouse.desafio3_webservices

import br.com.digitalhouse.desafio3_webservices.model.Auxiliar
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Service {

    @GET("comics?apikey= nº API")
    suspend fun getAllHQ(): Auxiliar
}


val retrofit = Retrofit.Builder()
    .baseUrl("https://gateway.marvel.com:443/v1/public/characters/1009610")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val service: Service = retrofit.create(Service::class.java)