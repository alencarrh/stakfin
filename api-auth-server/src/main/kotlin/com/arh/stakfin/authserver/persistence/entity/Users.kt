package com.arh.stakfin.authserver.persistence.entity

import jakarta.persistence.*

@Entity
data class Users(
    @Id @Column(name = "username", length = 50, nullable = false) val username: String,
    @Column(name = "password", length = 100, nullable = false) val password: String,
    @Column(name = "enabled", nullable = false) val enabled: Boolean,
    @OneToMany(mappedBy = "username", fetch = FetchType.EAGER) val authorities: List<Authorities>
)
