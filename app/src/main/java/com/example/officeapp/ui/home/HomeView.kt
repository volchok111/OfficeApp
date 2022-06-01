package com.example.officeapp.ui.home

import com.arellomobile.mvp.MvpView

interface HomeView: MvpView {
    fun onRequestStart()
    fun onRequestComplete()
    fun onRequestError(message: Int)
    fun onConnectionAbsence()
}