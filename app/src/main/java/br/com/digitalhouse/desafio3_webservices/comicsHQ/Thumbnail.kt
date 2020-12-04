package br.com.digitalhouse.desafio3_webservices.comicsHQ
import com.google.gson.annotations.SerializedName


data class Thumbnail (
	@SerializedName("path") val path : String,
	@SerializedName("extension") val extension : String
)