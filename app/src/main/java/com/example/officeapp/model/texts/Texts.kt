package com.example.officeapp.model.texts

/**
 *
 * @property {Int} code - The HTTP status code of the response.
 * @property {List<Data>} `data` - This is the list of data that we want to display in our
 * RecyclerView.
 * @property {String} status - The status of the request.
 * @property {Int} total - The total number of results.
 */
data class Texts(
    val code: Int,
    val `data`: List<Data>,
    val status: String,
    val total: Int
)