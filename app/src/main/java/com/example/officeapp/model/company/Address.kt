package com.example.officeapp.model.company

import java.io.Serializable

/**
 * `Address` is a data class that has 10 properties: `buildingNumber`, `city`, `country`,
 * `county_code`, `id`, `latitude`, `longitude`, `street`, `streetName`, and `zipcode`.
 * @property {String} buildingNumber - The building number of the address.
 * @property {String} city - The city of the address.
 * @property {String} country - The country where the address is located.
 * @property {String} county_code - The county code of the address.
 * @property {Int} id - The unique id of the address
 * @property {Double} latitude - The latitude of the address.
 * @property {Double} longitude - The longitude of the address.
 * @property {String} street - The name of the street
 * @property {String} streetName - The name of the street
 * @property {String} zipcode - The zipcode of the address
 */
data class Address(
    val buildingNumber: String,
    val city: String,
    val country: String,
    val county_code: String,
    val id: Int,
    val latitude: Double,
    val longitude: Double,
    val street: String,
    val streetName: String,
    val zipcode: String
): Serializable