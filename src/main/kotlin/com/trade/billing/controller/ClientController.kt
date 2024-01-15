package com.trade.billing.controller

import com.trade.billing.model.Client
import com.trade.billing.service.ClientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
@RestController
@RequestMapping("/client-app")
class ClientController {
    @Autowired
    lateinit var clientService: ClientService
    @GetMapping
    fun list (client:Client, pageable: Pageable):ResponseEntity<*>{
        val response= clientService.list(pageable,client)
        return ResponseEntity(response, HttpStatus.OK)
    }
//@RequestParam searchValue:String

    @GetMapping("/{id}")
    fun listOne (@PathVariable id: Long) : Optional<Client> {
        return clientService.listOne(id)
    }

    //Peticiones post - Clase controller
    @PostMapping
    fun save (@RequestBody modelo: Client): ResponseEntity<Client> {
        return ResponseEntity(clientService.save(modelo), HttpStatus.OK)
    }

    //clase controller - Petición Put
    @PutMapping
    fun update (@RequestBody modelo: Client): ResponseEntity<Client> {
        return ResponseEntity(clientService.update(modelo), HttpStatus.OK)
    }

    //clase  controller-Petiicon Patch
    @PatchMapping
    fun updateName (@RequestBody modelo: Client): ResponseEntity<Client> {
        return ResponseEntity(clientService.update(modelo), HttpStatus.OK)
    }

    //clase  controller - Petición Delete
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return clientService.delete(id)
    }
}