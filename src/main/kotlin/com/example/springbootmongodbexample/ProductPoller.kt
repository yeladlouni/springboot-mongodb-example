package com.example.springbootmongodbexample

import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
@EnableScheduling
class ProductPoller(private val repository: ProductRepository) {
    private val client = WebClient.create("http://localhost:7654/products")

    @Scheduled(fixedDelay = 1000)
    private fun pollProducts() {
        repository.deleteAll()

        client.get()
            .retrieve()
            .bodyToFlux<Product>()
            .toStream()
            .forEach { repository.save(it)}

        repository.findAll().forEach { println(it)}
    }
}