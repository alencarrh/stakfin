package com.arh.studies.apiauthserver.persistence.entity

import jakarta.persistence.Column
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import org.springframework.security.core.GrantedAuthority

data class Users(
  @Id
  @Column(name = "username", length = 50, nullable = false)
  val username: String,
  @Column(name = "password", length = 100, nullable = false)
  val password: String,
  @Column(name = "enabled", nullable = false)
  val enabled: Boolean,

  @OneToMany(mappedBy = "username", fetch = FetchType.EAGER)
  val authorities: List<GrantedAuthority>
)
