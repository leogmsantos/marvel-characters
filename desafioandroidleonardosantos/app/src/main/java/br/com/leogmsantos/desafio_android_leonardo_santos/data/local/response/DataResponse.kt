package br.com.leogmsantos.desafio_android_leonardo_santos.data.local.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataResponse (
    @SerializedName("data")
    var data: CharactersResponse
) : Parcelable