package com.example.officeapp.ui.home

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment


open class HomeFragment : MvpAppCompatFragment(), HomeView {
    override fun onRequestStart() {

    }

    override fun onRequestComplete() {

    }

    /**
     * It shows a toast message with the error message.
     *
     * @param message The message to be displayed in the Toast.
     */
    override fun onRequestError(message: Int) {
        Toast.makeText(context, getString(message), Toast.LENGTH_LONG).show()
    }

    /**
     * It shows a toast message when there is no internet connection.
     */
    override fun onConnectionAbsence() {
        context.let {
            Toast.makeText(it, "Error connection absence", Toast.LENGTH_LONG).show()
        }
    }

    /**
     * > This function takes a phone number as a string, creates an intent to dial that number, and
     * then starts the activity
     *
     * @param phoneNumber The phone number to call.
     */


    /**
     * > This function takes a phone number as a string, creates an intent to dial that number, and
     * then starts the activity
     *
     * @param phoneNumber The phone number to call.
     */
    open fun onMakeCall(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null))
        startActivity(intent)
    }


    /**
     * It opens the email app and sends an email to the address provided.
     *
     * @param addresses The email addresses to send the email to.
     * @param subject The subject of the email
     */
    open fun onSendEmail(addresses: String, subject: String) {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:")
        intent.putExtra(Intent.EXTRA_EMAIL, addresses)
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)

        startActivity(intent)

    }

    /**
     * It opens the google map with the given latitude and longitude.
     *
     * @param lat latitude of the location
     * @param lon Longitude
     */
    open fun onShowMap(lat: String, lon: String) {
        val navigationIntentUri =
            Uri.parse("google.navigation:q=$lat,$lon") //creating intent with latlng

        val mapIntent = Intent(Intent.ACTION_VIEW, navigationIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }
}

