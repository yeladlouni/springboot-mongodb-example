package com.example.springbootmongodbexample

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
@JsonIgnoreProperties(ignoreUnknown = true)
data class Product(
    @Id val id: String,
    val label: String? = "",
    val manufacturer: String? = "",
    val price: Double = 0.0,
    val length: Double = 0.0,
    val width: Double = 0.0,
    val height: Double = 0.0,
    val weight: Double = 0.0,
    val color: String = "white",
    val category: String = "health"
)