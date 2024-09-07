package com.arh.stakfin.core

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication class OrderApiApplication

fun main(args: Array<String>) {
  runApplication<OrderApiApplication>(*args)
}
