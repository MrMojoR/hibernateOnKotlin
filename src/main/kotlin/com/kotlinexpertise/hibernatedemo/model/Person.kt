package com.kotlinexpertise.hibernatedemo.model

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.OneToOne

@Entity
class Person(
    val name: String,
    @ManyToOne(cascade = [(CascadeType.ALL)], fetch = FetchType.EAGER)
    val street: Street
) : AbstractJpaPersistable<Long>()

@Entity
class Address(
    val zipCode: String,
    val city: String
) : AbstractJpaPersistable<Long>()

@Entity
class Street(
        @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY)
        val adresses: MutableSet<Address>
): AbstractJpaPersistable<Long>()