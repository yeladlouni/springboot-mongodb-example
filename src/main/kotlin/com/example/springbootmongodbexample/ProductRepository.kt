package com.example.springbootmongodbexample

import org.springframework.data.repository.CrudRepository

interface ProductRepository: CrudRepository<Product, String>