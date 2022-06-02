package com.example.officeapp.model.company

import java.io.Serializable

/**
 * `Companies` is a data class that has 4 properties: `code`, `data`, `status`, and `total`.
 *
 * The `code` property is an `Int`, the `data` property is a `List<CompanyModel>`, the `status`
 * property is a `String`, and the `total` property is an `Int`.
 *
 * The `data` property is a list of `CompanyModel` objects.
 *
 * The `CompanyModel` type is defined as follows:
 * @property {Int} code - The HTTP status code of the response.
 * @property {List<CompanyModel>} `data` - This is the list of companies that we will be displaying in
 * our RecyclerView.
 * @property {String} status - The status of the response.
 * @property {Int} total - The total number of companies in the database.
 */
data class Companies(
    val code: Int,
    val `data`: List<CompanyModel>,
    val status: String,
    val total: Int
): Serializable