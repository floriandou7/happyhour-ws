package com.floriandoussin.HappyHour

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import java.util.*


@SpringBootApplication
class HappyHourApplication

fun main(args: Array<String>) {
	runApplication<HappyHourApplication>(*args)
}
