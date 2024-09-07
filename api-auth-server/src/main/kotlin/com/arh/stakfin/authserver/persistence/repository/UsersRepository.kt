package com.arh.stakfin.authserver.persistence.repository

import com.arh.studies.apiauthserver.persistence.entity.Users
import org.springframework.data.repository.CrudRepository

interface UsersRepository : CrudRepository<Users, String> {}
