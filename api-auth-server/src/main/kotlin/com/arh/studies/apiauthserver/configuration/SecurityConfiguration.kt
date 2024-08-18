package com.arh.studies.apiauthserver.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer.withDefaults
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import javax.sql.DataSource


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
class SecurityConfiguration(private val dataSource: DataSource) {

  @Bean
  fun securityFilterChainConfiguration(http: HttpSecurity): SecurityFilterChain {
    return http.authorizeHttpRequests {
      //swagger
      it.requestMatchers("/", "/swagger/**").permitAll()

      // secure endpoints
      it.requestMatchers("/api/**").authenticated()
      it.requestMatchers("/api/user/**").hasRole("USER")
      it.requestMatchers("/api/admin/**").hasRole("ADMIN")
      it.anyRequest().authenticated()

      }.formLogin { it.disable() }.httpBasic(withDefaults()).build()
  }

  @Bean
  fun passwordEncoder(): PasswordEncoder {
    return BCryptPasswordEncoder()
  }

  @Autowired
  @Throws(Exception::class)
  fun configureGlobal(auth: AuthenticationManagerBuilder) {
    auth.jdbcAuthentication().dataSource(dataSource)
  }
}