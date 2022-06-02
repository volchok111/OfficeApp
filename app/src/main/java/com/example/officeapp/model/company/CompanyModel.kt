package com.example.officeapp.model.company

import java.io.Serializable

/**
 * `CompanyModel` is a data class that has a list of `Addresse` objects, a `Contact` object, a `String`
 * country, a `String` email, an `Int` id, a `String` image, a `String` name, a `String` phone, a
 * `String` vat, and a `String` website.
 * @property {List<Addresse>} addresses - A list of addresses.
 * @property {Contact} contact - This is a nested object that contains the contact information of the
 * company.
 * @property {String} country - The country where the company is located.
 * @property {String} email - The email address of the company.
 * @property {Int} id - The id of the company.
 * @property {String} image - The image of the company.
 * @property {String} name - The name of the company.
 * @property {String} phone - The phone number of the company.
 * @property {String} vat - The VAT number of the company.
 * @property {String} website - The website of the company.
 */
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