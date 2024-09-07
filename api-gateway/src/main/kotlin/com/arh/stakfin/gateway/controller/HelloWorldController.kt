package com.arh.studies.sqslistener.controller

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hello")
class HelloWorldController() {

    private val logger = KotlinLogging.logger {}

    @GetMapping("/world")
    fun startListener(): String {
        logger.info { "Hello" }

        return "Hello World"

    }
}
