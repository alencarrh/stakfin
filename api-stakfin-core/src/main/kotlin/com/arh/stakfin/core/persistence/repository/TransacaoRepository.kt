package com.arh.stakfin.core.persistence.repository

import com.arh.stakfin.core.persistence.entity.TransacaoEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TransacaoRepository : JpaRepository<TransacaoEntity, String> {}
