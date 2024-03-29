package com.floriandoussin.HappyHour.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
data class Question (
        @Id @GeneratedValue(strategy = GenerationType.TABLE)
        val id: Long = 0,

    @get: NotBlank
    val text: String = ""
    )
