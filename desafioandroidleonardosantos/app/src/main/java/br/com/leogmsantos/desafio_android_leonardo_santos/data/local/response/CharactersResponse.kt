package br.com.leogmsantos.desafio_android_leonardo_santos.data.local.response

import android.os.Parcelable
import br.com.leogmsantos.desafio_android_leonardo_santos.dto.Character
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharactersResponse (
    @SerializedName("results")
    val characters: List<Character>
) : Parcelable