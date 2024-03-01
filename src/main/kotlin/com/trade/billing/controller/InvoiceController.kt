package com.trade.billing.controller

import com.trade.billing.model.Invoice
import com.trade.billing.service.InvoiceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
@RestController
@RequestMapping("/invoice")
class InvoiceController {
    @Autowired
    lateinit var invoiceService: InvoiceService
    @GetMapping
    fun list ():List <Invoice>{
        return invoiceService.list()
    }

    @GetMapping("/{id}")
    fun listOne (@PathVariable id: Long) : Optional<Invoice> {
        return invoiceService.listOne(id)
    }
    @GetMapping("/filter-total/{value}")
    fun listTotals (@PathVariable value: Double ):ResponseEntity<*>{
        return ResponseEntity(invoiceService.filterTotal(value), HttpStatus.OK)
    }

    //Peticiones post
    @PostMapping
    fun save (@RequestBody invoice: Invoice): ResponseEntity<Invoice> {
        return ResponseEntity(invoiceService.save(invoice), HttpStatus.OK)
    }

    //Petición Put
    @PutMapping
    fun update (@RequestBody invoice: Invoice): ResponseEntity<Invoice> {
        return ResponseEntity(invoiceService.update(invoice), HttpStatus.OK)
    }

    //Petiicon Patch
    @PatchMapping
    fun updateName (@RequestBody invoice: Invoice): ResponseEntity<Invoice> {
        return ResponseEntity(invoiceService.update(invoice), HttpStatus.OK)
    }

    //Petición Delete
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return invoiceService.delete(id)
    }
}