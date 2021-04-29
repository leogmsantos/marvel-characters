package br.com.leogmsantos.desafio_android_leonardo_santos.dto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Thumbnail (
    var path: String = "",
    var extension: String = ""
) : Parcelable