package com.arh.studies.apiauthserver.configuration

import io.swagger.v3.oas.annotations.Hidden
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.view.RedirectView

@Configuration
@RestController
class SwaggerConfiguration {

  private val SWAGGER_UI = "/swagger/swagger-ui/index.html"

  @GetMapping("/")
  @Hidden
  fun swagger(): RedirectView = RedirectView(SWAGGER_UI)

}
