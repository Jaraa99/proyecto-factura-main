package com.trade.billing.controller

import com.trade.billing.model.Product
import com.trade.billing.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
@RestController
@RequestMapping("/product-control")
class ProductController {
    @Autowired
    lateinit var productService: ProductService

    @GetMapping
    fun list(product: Product): ResponseEntity<*> {
        val response = productService.list(product)
        return ResponseEntity(response, HttpStatus.OK)
    }
    
    @GetMapping("/list-dto")
    fun lisDto(): ResponseEntity<*>{
        return ResponseEntity(productService.listDto(), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun listOne (@PathVariable id: Long) : Optional<Product> {
        return productService.listOne(id)
    }

    //Petitions post
    @PostMapping
    fun save (@RequestBody product: Product): ResponseEntity<Product> {
        return ResponseEntity(productService.save(product), HttpStatus.OK)
    }

    //Petitions Put
    @PutMapping
    fun update (@RequestBody product: Product): ResponseEntity<Product> {
        return ResponseEntity(productService.update(product), HttpStatus.OK)
    }

    //Petitions Patch
    @PatchMapping
    fun updateName (@RequestBody product: Product): ResponseEntity<Product> {
        return ResponseEntity(productService.update(product), HttpStatus.OK)
    }

    //Petitions Delete
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return productService.delete(id)
    }
}