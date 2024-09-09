package com.arh.stakfin.core.persistence.rendafixa.repository

import com.arh.stakfin.core.persistence.rendafixa.entity.RendaFixaAtivoEntity
import org.springframework.data.jpa.repository.JpaRepository

interface RendaFixaRepository : JpaRepository<RendaFixaAtivoEntity, Long> {}
