package com.example.officeapp.model

data class Companies(
    val code: Int,
    val `data`: List<CompanyModel>,
    val status: String,
    val total: Int
)