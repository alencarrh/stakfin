package com.arh.stakfin.core.model.exception.base

abstract class AbstractException(val errorCode: ErrorCode, val details: Map<String, String>) : RuntimeException()