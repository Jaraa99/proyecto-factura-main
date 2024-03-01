package com.trade.billing.service

import com.trade.billing.model.Product
import com.trade.billing.repository.ProductRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProductServiceTest {
    @InjectMocks
    lateinit var productService: ProductService //clae que se va a probar

    @Mock   //objeto simulado
    lateinit var productRepository: ProductRepository

    val clientMock = Product().apply {
        id=1
        description="bombaANT"
        brand= "ACCNE"
        price= 90.60,
        stock= 100
    }

    @Test
    fun saveProductCorrect(){
        Mockito.`when`(productRepository.save(Mockito.any(Product::class.java))).thenReturn(clientMock)
        val response = productService.save(productMock)
        Assertions.assertEquals(response.id, productMock.id)
    }


    @Test
    fun saveProductWhenFullnameIsBlank(){

        Assertions.assertThrows(Exception::class.java) {
            clientMock.apply { description=" "}
            Mockito.`when`(productRepository.save(Mockito.any(Product::class.java))).thenReturn(clientMock)
            productService.save(clientMock)
        }

    }
}