package com.laksamana.movio.movie_detail.data.remote.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Genre( //TODO: DTO untuk ID dan nama genre sebuah film
    @SerialName("id")
    val id: Int? = null,
    @SerialName("name")
    val name: String? = null
)