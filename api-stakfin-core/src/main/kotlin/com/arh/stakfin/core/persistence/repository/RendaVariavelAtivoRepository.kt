package com.arh.stakfin.core.persistence.repository

import com.arh.stakfin.core.persistence.entity.RendaVariavelAtivoEntity
import java.util.*
import org.springframework.data.jpa.repository.JpaRepository

interface RendaVariavelAtivoRepository : JpaRepository<RendaVariavelAtivoEntity, Long> {

  fun findByTicker_Id(tickerId: String): Optional<RendaVariavelAtivoEntity>
}
