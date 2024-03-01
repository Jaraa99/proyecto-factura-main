package com.trade.billing.service

import com.trade.billing.model.Client
import com.trade.billing.repository.ClientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class ClientService {
    @Autowired
    lateinit var clientRepository: ClientRepository

    //GET
    fun list(client: Client): List<Client> {
        val matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()
            .withMatcher(("fullName"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
        return clientRepository.findAll(Example.of(client, matcher));
    }

    //Get para listar uno por uno
    fun listOne (id: Long): Optional<Client> {
        return clientRepository.findById(id)
    }

    //POST
    fun save(client: Client): Client{
        try{
            client.fullName?.takeIf { it.trim().isNotEmpty() }
                ?:  throw  Exception("Nombres no deben ser nulos")
            return clientRepository.save(client)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    //Put
    fun update(client: Client): Client{
        try {
            clientRepository.findById(client.id)
                ?: throw Exception("No existe ID")

            return clientRepository.save(client)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    //Delete by id
    fun delete (id: Long?):Boolean?{
        try{
            val response = clientRepository.findById(id)
                ?: throw Exception("No existe ID")
            clientRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}