package com.example.demo.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Books(
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @JsonProperty(value = "id", access = JsonProperty.Access.READ_ONLY)
    val id: Long? = 0L,
    val name: String = "",
    val number: Int = 0
)