package com.henrik.coroutinesmvp.data.entity

import com.google.gson.annotations.SerializedName

data class Gato(
    @SerializedName("file")
    val imagem: String
)