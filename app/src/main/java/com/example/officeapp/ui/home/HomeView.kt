package com.example.officeapp.ui.home

import com.arellomobile.mvp.MvpView

interface HomeView: MvpView {

    /**
     * This function is called when the request is started.
     */
    fun onRequestStart()

    /**
     * `onRequestComplete` is a function that takes no arguments and returns nothing.
     */
    fun onRequestComplete()

    /**
     * `onRequestError` is a function that takes an integer and returns nothing.
     *
     * @param message The message to be displayed in the snackbar.
     */
    fun onRequestError(message: Int)

    /**
     * A function that is called when the connection is lost.
     */
    fun onConnectionAbsence()
}