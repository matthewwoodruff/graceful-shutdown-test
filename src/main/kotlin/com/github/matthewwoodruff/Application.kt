package com.github.matthewwoodruff

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args) {}
}

@RestController
class Controller{

    @GetMapping("/wait")
    fun wait(): ResponseEntity<String> {
        Thread.sleep(10000)
        return ResponseEntity.ok("success")
    }
}
