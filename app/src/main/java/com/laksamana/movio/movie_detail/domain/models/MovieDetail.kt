package com.laksamana.movio.movie_detail.domain.models

data class MovieDetail( //TODO: Data class sebagai bagian dari domain untuk mengambil data dari Dto
    val backdropPath: String, //TODO: Data detail tentang sebuah film, seperti genre, bahasa, judul,rating, reviews, dsb
    val genreIds: List<String>,
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val voteAverage: Double,
    val voteCount: Int,
    val video: Boolean,
    val cast: List<Cast>,
    val language: List<String>,
    val productionCountry: List<String>,
    val reviews: List<Review>,
    val runTime: String
)

data class Cast( //TODO: Data mengenai aktor dan aktris sebuah film, seperti nama, karakter, link profile, dsb
    val id: Int,
    val name: String,
    val genderRole: String,
    val character: String,
    val profilePath: String?,
) {
    private val nameParts = name.split(" ", limit = 2) //TODO: Data nama dipisah menjadi dua bagian, nama awal dan nama akhir
    val firstName = nameParts[0]
    val lastName = nameParts[1]
}

data class Review( //TODO: Data review seseorang terhadap film tersebut
    val author: String,
    val content: String,
    val id: String,
    val createdAt: String,
    val rating:Double
)