package com.arh.stakfin.core.persistence.repository

import com.arh.stakfin.core.persistence.entity.TickerEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TickerRepository : JpaRepository<TickerEntity, String> {}
