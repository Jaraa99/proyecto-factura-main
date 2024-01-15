package com.trade.billing.service

import com.trade.billing.model.Client
import com.trade.billing.repository.ClientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*
@Service
class ClientService {
    @Autowired
    lateinit var clientRepository: ClientRepository

    fun list (pageable: Pageable,client:Client):Page<Client>{
        val matcher = ExampleMatcher.matching()
                .withIgnoreNullValues()
                .withMatcher(("fullName"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return clientRepository.findAll(Example.of(client, matcher), pageable)
    }

    fun listOne (id: Long): Optional<Client> {
        return clientRepository.findById(id)
    }

    //PETICIONES POST
    //clase service
    fun save(modelo: Client): Client{
        try{
            return clientRepository.save(modelo)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    //clase service -Petición put
    fun update(modelo: Client): Client{
        try {
            clientRepository.findById(modelo.id)
                    ?: throw Exception("ID no existe")

            return clientRepository.save(modelo)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    //clase service - Delete by id
    fun delete (id: Long?):Boolean?{
        try{
            val response = clientRepository.findById(id)
                    ?: throw Exception("ID no existe")
            clientRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}