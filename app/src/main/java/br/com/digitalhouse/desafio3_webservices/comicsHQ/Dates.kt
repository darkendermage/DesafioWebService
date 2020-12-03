package br.com.digitalhouse.desafio3_webservices.comicsHQ
import com.google.gson.annotations.SerializedName

data class Dates (

	@SerializedName("type") val type : String,
	@SerializedName("date") val date : String
)