package fr.solutec.lab.dumbstudent

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.context.annotation.Bean
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
class DumbStudentApplication(private val uppercaseService: UppercaseService) {

    @Bean
    fun askForUpperCase() = { s: String -> uppercaseService.toUpperCase(s) }


    @FeignClient(name = "uppercase")
    interface UppercaseService {
        @GetMapping("/toUpperCase/{s}")
        fun toUpperCase(@PathVariable("s") s: String): String

    }
}

fun main(args: Array<String>) {
    runApplication<DumbStudentApplication>(*args)
}
