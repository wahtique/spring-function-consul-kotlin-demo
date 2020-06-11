package fr.solutec.lab.mark

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.context.annotation.Bean
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
class MarkApplication(private val schoolPostgrestService: SchoolPostgrestService) {

	@FeignClient(name = "postgrest")
	interface SchoolPostgrestService {
		@PostMapping("/marks")
		fun insertStudent(s: Student)

		@GetMapping("/marks?name=eq.{name}")
		fun getStudent(@PathVariable("name") name: String): List<Student>
	}

	data class Mark(val subject: String, val mark: Float)

	data class Student(val name: String, val marks: List<Mark>)

	@Bean
	fun insertStudent() = { s: Student -> schoolPostgrestService.insertStudent(s)}

	@Bean
	fun getStudent() = { n: String -> schoolPostgrestService.getStudent(n) }
}

fun main(args: Array<String>) {
	runApplication<MarkApplication>(*args)
}
