package fr.solutec.lab.uppercase

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class UppercaseApplication {
    @Bean
    fun toUpperCase() = { s: String -> s.toUpperCase() }
}

fun main(args: Array<String>) {
    runApplication<UppercaseApplication>(*args)
}
