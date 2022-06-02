package com.example.officeapp.model.company

import java.io.Serializable

/**
 * `Contact` is a data class that has 10 properties: `address`, `birthday`, `email`, `firstname`,
 * `gender`, `id`, `image`, `lastname`, `phone`, and `website`.
 *
 * The `address` property is of type `Address`, which is a data class that has 3 properties: `city`,
 * `street`, and `zipcode`.
 *
 * The `birthday`, `email`, `firstname`, `gender`, `image`, `lastname`, `phone`, and `website`
 * properties are all of
 * @property {Address} address - The address of the contact
 * @property {String} birthday - The birthday of the contact.
 * @property {String} email - The email address of the contact.
 * @property {String} firstname - The first name of the contact
 * @property {String} gender - The gender of the contact.
 * @property {Int} id - The unique ID of the contact.
 * @property {String} image - The image of the contact
 * @property {String} lastname - The last name of the contact
 * @property {String} phone - The phone number of the contact.
 * @property {String} website - The website of the contact
 */
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
): Serializable