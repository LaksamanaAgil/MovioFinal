package com.laksamana.movio.common.data

interface ApiMapper<Domain,Entity> { //TODO: Memetakan/ mengarahkan data yang diambil dari API ke Dto
    fun mapToDomain(apiDto:Entity):Domain
}