package com.example.officeapp.model

data class Contact(
    val address: Address,
    val birthday: String,
    val email: String,
    val firstname: String,
    val gender: String,
    val id: Int,
    val image: String,
    val lastname: String,
    val phone: String,
    val website: String
)