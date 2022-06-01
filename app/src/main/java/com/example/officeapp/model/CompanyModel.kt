package com.example.officeapp.model

import java.io.Serializable

data class CompanyModel(
    val addresses: List<Addresse>,
    val contact: Contact,
    val country: String,
    val email: String,
    val id: Int,
    val image: String,
    val name: String,
    val phone: String,
    val vat: String,
    val website: String
): Serializable