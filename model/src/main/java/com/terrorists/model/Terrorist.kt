package com.terrorists.model

data class Terrorist(val firstName: String, val lastName: String) {
    val name: String
        get() = "$firstName $lastName".trim()
}