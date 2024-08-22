package com.arh.studies.apiauthserver.persistence.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class Authorities(
    @Id val username: String,
    val authority: String,
)
