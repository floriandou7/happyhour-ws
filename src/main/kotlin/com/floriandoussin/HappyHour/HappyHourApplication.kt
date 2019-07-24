package com.floriandoussin.HappyHour

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.*

@SpringBootApplication
class HappyHourApplication

fun main(args: Array<String>) {
	runApplication<HappyHourApplication>(*args)


	@Bean
	fun commandLineRunner(ctx: ApplicationContext): CommandLineRunner {
		return { args ->

			println("Let's inspect the beans provided by Spring Boot:")

			val beanNames = ctx.getBeanDefinitionNames()
			Arrays.sort(beanNames)
			for (beanName in beanNames) {
				println(beanName)
			}

		}
	}
}
