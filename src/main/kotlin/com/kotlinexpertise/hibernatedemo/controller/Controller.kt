package com.kotlinexpertise.hibernatedemo.controller

import com.kotlinexpertise.hibernatedemo.model.Address
import com.kotlinexpertise.hibernatedemo.model.Person
import com.kotlinexpertise.hibernatedemo.model.Street
import com.kotlinexpertise.hibernatedemo.repository.PersonRepository
import com.kotlinexpertise.hibernatedemo.service.PersonService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class Controller(val personRepository: PersonRepository,
                 val personService: PersonService){

    @GetMapping
    fun test(): Boolean {
        personService.savePerson(Person("Paul", (Street(mutableSetOf(Address( "A-55", "Paris"))))))
        val person = personRepository.findAll()[0]
        return true
    }
}