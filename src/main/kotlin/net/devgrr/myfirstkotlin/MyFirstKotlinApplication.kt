package net.devgrr.myfirstkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class MyFirstKotlinApplication

fun main(args: Array<String>) {
    runApplication<MyFirstKotlinApplication>(*args)
}
