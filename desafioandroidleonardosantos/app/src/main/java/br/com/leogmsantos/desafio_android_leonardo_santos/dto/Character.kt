package br.com.leogmsantos.desafio_android_leonardo_santos.dto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Character (
    var id: Int = 0,
    var name: String = "",
    var description: String ="",
    var thumbnail: Thumbnail? = null
) : Parcelable