package com.laksamana.movio.common.data

interface ApiMapper<Domain,Entity> {
    fun mapToDomain(apiDto:Entity):Domain
}