package br.com.digitalhouse.desafio3_webservices.model
import com.google.gson.annotations.SerializedName

data class DataComic (

	@SerializedName("offset") val offset : Int,
	@SerializedName("limit") val limit : Int,
	@SerializedName("total") val total : Int,
	@SerializedName("count") val count : Int,
	@SerializedName("results") val results : List<Result>
)