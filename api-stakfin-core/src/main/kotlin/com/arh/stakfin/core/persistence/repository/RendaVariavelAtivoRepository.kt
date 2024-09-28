package com.arh.stakfin.core.persistence.repository

import com.arh.stakfin.core.persistence.entity.RendaVariavelAtivoEntity
import org.springframework.data.jpa.repository.JpaRepository

interface RendaVariavelAtivoRepository : JpaRepository<RendaVariavelAtivoEntity, Long> {
}