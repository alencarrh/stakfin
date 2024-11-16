package com.arh.stakfin.core.persistence.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "ticker_history")
data class TickerValueHistoryEntity(@Id val ticker: String, val data: LocalDate, val valor: Long)
