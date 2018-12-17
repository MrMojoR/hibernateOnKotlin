package com.kotlinexpertise.hibernatedemo

import com.kotlinexpertise.hibernatedemo.model.Address
import com.kotlinexpertise.hibernatedemo.model.Person
import com.kotlinexpertise.hibernatedemo.model.Street
import com.kotlinexpertise.hibernatedemo.repository.PersonRepository
import com.kotlinexpertise.hibernatedemo.service.PersonService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest
class HibernateDemoApplicationTests(@Autowired val repo: PersonRepository,
                                    @Autowired val service: PersonService) {

    @Test
    fun test() {
        service.savePerson(Person("Paul", (Street(mutableSetOf(Address( "A-55", "Paris"))))))
        val person = repo.findAll()[0]
        println(person)
    }
}
