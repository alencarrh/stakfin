package com.arh.studies.apiauthserver.configuration

import com.nimbusds.jose.jwk.JWKSet
import com.nimbusds.jose.jwk.RSAKey
import com.nimbusds.jose.jwk.source.ImmutableJWKSet
import com.nimbusds.jose.proc.SecurityContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.jdbc.core.JdbcOperations
import org.springframework.security.config.Customizer.withDefaults
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.oauth2.core.AuthorizationGrantType
import org.springframework.security.oauth2.core.ClientAuthenticationMethod
import org.springframework.security.oauth2.jwt.JwtDecoder
import org.springframework.security.oauth2.jwt.JwtEncoder
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder
import org.springframework.security.oauth2.server.authorization.JdbcOAuth2AuthorizationConsentService
import org.springframework.security.oauth2.server.authorization.JdbcOAuth2AuthorizationService
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationConsentService
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService
import org.springframework.security.oauth2.server.authorization.client.JdbcRegisteredClientRepository
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings
import org.springframework.security.web.SecurityFilterChain
import javax.sql.DataSource


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
class SecurityConfiguration(private val dataSource: DataSource) {


  @Bean
  @Order(Ordered.HIGHEST_PRECEDENCE)
  @Throws(java.lang.Exception::class)
  fun defaultFilterChain(http: HttpSecurity): SecurityFilterChain {
    OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(http)
    return http.formLogin(withDefaults()).build()
  }

  @Bean
  fun securityFilterChainConfiguration(http: HttpSecurity): SecurityFilterChain {
    return http.authorizeHttpRequests {
      // swagger
      it.requestMatchers("/", "/swagger/**").permitAll()
      it.anyRequest().authenticated()
    }
      .build()
  }


  @Bean
  fun registeredClientRepository(
    passwordEncoder: PasswordEncoder,
    jdbcTemplate: JdbcTemplate?
  ): RegisteredClientRepository {
    val awuserClient = RegisteredClient
      .withId("1")
      .clientId("awuser")
      .clientSecret(passwordEncoder.encode("123456"))
      .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
      .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
      .scope("users:read")
      .scope("users:write")
      .tokenSettings(
        TokenSettings.builder()
          .accessTokenTimeToLive(Duration.ofMinutes(5))
          .build()
      )
      .clientSettings(
        ClientSettings.builder()
          .requireAuthorizationConsent(false)
          .build()
      )
      .build()

    val awblogClient = RegisteredClient
      .withId("2")
      .clientId("awblog")
      .clientSecret(passwordEncoder.encode("123456"))
      .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
      .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
      .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
      .redirectUri("http://localhost:3000/authorized")
      .redirectUri("https://oidcdebugger.com/debug")
      .redirectUri("https://oauth.pstmn.io/v1/callback")
      .scope("myuser:read")
      .scope("myuser:write")
      .scope("posts:write")
      .tokenSettings(
        TokenSettings.builder()
          .accessTokenTimeToLive(Duration.ofMinutes(15))
          .refreshTokenTimeToLive(Duration.ofDays(1))
          .reuseRefreshTokens(false)
          .build()
      )
      .clientSettings(
        ClientSettings.builder()
          .requireAuthorizationConsent(true)
          .build()
      )
      .build()

    val clientRepository = JdbcRegisteredClientRepository(jdbcTemplate)

    //        clientRepository.save(awblogClient);
//        clientRepository.save(awuserClient);
    return clientRepository
  }

  @Bean
  fun auth2AuthorizationService(
    jdbcOperations: JdbcOperations?,
    registeredClientRepository: RegisteredClientRepository?
  ): OAuth2AuthorizationService {
    return JdbcOAuth2AuthorizationService(
      jdbcOperations,
      registeredClientRepository
    )
  }

  @Bean
  fun oAuth2AuthorizationConsentService(
    jdbcOperations: JdbcOperations?,
    registeredClientRepository: RegisteredClientRepository?
  ): OAuth2AuthorizationConsentService {
    return JdbcOAuth2AuthorizationConsentService(
      jdbcOperations,
      registeredClientRepository
    )
  }

  @Bean
  fun passwordEncoder(): PasswordEncoder {
    return BCryptPasswordEncoder()
  }

  @Bean
  fun jwtDecoder(rsaKey: RsaKeyProperties): JwtDecoder {
    return NimbusJwtDecoder.withPublicKey(rsaKey.publicKey).build();
  }

  @Bean
  fun jwtEnconder(rsaKey: RsaKeyProperties): JwtEncoder {
    val key = RSAKey.Builder(rsaKey.publicKey).privateKey(rsaKey.privateKey).build()
    val jwkSet = ImmutableJWKSet<SecurityContext>(JWKSet(key))
    return NimbusJwtEncoder(jwkSet)
  }

  @Autowired
  @Throws(Exception::class)
  fun configureGlobal(auth: AuthenticationManagerBuilder) {
    auth.jdbcAuthentication().dataSource(dataSource)
  }
}
