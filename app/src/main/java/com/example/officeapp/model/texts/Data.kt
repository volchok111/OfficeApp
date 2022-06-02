package com.example.officeapp.model.texts

/**
 *
 * @property {String} author - The author of the book.
 * @property {String} content - The text of the review.
 * @property {String} genre - The genre of the book.
 * @property {String} title - The title of the book.
 */
data class Data(
    val author: String,
    val content: String,
    val genre: String,
    val title: String
)