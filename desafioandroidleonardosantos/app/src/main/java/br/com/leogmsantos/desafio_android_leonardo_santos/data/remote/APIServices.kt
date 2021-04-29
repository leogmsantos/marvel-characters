package br.com.leogmsantos.desafio_android_leonardo_santos.data.remote

import br.com.leogmsantos.desafio_android_leonardo_santos.BuildConfig
import br.com.leogmsantos.desafio_android_leonardo_santos.data.local.response.CharactersResponse
import br.com.leogmsantos.desafio_android_leonardo_santos.data.local.response.DataResponse
import br.com.leogmsantos.desafio_android_leonardo_santos.dto.Character
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.math.BigInteger
import java.security.MessageDigest

interface APIServices {

    @GET("characters")
    fun getCharacters(@Query("ts") ts: String = System.currentTimeMillis().toString(),
                      @Query("apikey") apiKey: String = BuildConfig.PUBLIC_KEY,
                      @Query("hash") hash: String = md5(ts + BuildConfig.PRIVATE_KEY + apiKey),
                      @Query("limit") limit: String = "20",
                      @Query("name") name: String? = null,
                      ) : Call<DataResponse>
}

 private fun md5(input:String): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
}