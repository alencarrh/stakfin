package com.arh.stakfin.core.model.exception

class ErrorMessage(
    val code: String,
    val message: String,
    val details: Map<String, String?> = emptyMap()
)
