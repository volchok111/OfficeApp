package com.example.officeapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment
import com.example.officeapp.R


open class HomeFragment : MvpAppCompatFragment(), HomeView {
    override fun onRequestStart() {

    }

    override fun onRequestComplete() {

    }

    override fun onRequestError(message: Int) {
        Toast.makeText(context, getString(message), Toast.LENGTH_LONG).show()
    }

    override fun onConnectionAbsence() {
        context.let {
            Toast.makeText(it, "Error connection absence", Toast.LENGTH_LONG).show()
        }
    }
}


