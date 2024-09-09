package com.arh.stakfin.core.model.exception.base

data class ErrorMessage(
    val code: String,
    val message: String,
    val details: Map<String, String?>? = emptyMap()
)
