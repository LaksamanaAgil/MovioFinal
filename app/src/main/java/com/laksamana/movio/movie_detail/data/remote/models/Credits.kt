package com.laksamana.movio.movie_detail.data.remote.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Credits( //TODO: Dto data mengenai aktor dan crew/awak produksi yang terlibat dalam pembuatan sebuah film
    @SerialName("cast")
    val cast: List<CastDto?>? = null,
    @SerialName("crew")
    val crew: List<Crew?>? = null
)