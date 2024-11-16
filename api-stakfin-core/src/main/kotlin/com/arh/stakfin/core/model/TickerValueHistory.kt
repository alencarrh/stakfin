package com.arh.stakfin.core.model

import java.time.LocalDate

data class TickerValueHistory(val ticker: String, val data: LocalDate, val valor: Long)
