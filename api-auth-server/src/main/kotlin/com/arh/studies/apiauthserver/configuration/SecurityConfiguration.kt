package com.arh.studies.apiauthserver.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfiguration {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .authorizeHttpRequests {
                it.requestMatchers("/public/**").permitAll()
                it.requestMatchers("/swagger-ui**").permitAll()
                it.requestMatchers("/api-docs").permitAll()
                it.requestMatchers("/user/**").hasRole("USER")
                it.requestMatchers("/admin/**").hasRole("ADMIN")
                it.anyRequest().authenticated()
            }
            .formLogin { it.permitAll() }
            .build()
    }

    @Bean
    fun userDetailsService(): UserDetailsService {
        val user =
            User.builder()
                .username("myuser")
                .password("\$2a\$14\$fkbFNyxo6ztPp1nKgk0tVOCoWlPPtWUOEX.fRXWlplfbIxoIsiw/i")
                .roles("USER")
                .build()

        val admin =
            User.builder()
                .username("myadmin")
                .password("\$2a\$14\$aws/HNYU8AAdqissQdoC6e91YP9ARBB1C7rKRqmEo8hHCfFnaqMSS")
                .roles("USER", "ADMIN")
                .build()

        return InMemoryUserDetailsManager(user, admin)
    }

    @Bean
    fun PasswordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}
