package com.kotlinexpertise.hibernatedemo.service

import com.kotlinexpertise.hibernatedemo.model.Person
import com.kotlinexpertise.hibernatedemo.repository.PersonRepository
import org.springframework.stereotype.Service

@Service
class PersonService(val personRepository: PersonRepository) {

    fun savePerson(person: Person) {
        personRepository.saveAndFlush(person)
    }
}