package com.example.officeapp.ui.home


import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment
import com.example.officeapp.api.ApiServiceImpl


open class HomeFragment : MvpAppCompatFragment(), HomeView {



    /**
     * A function that is called when the request is started.
     */
    override fun onRequestStart() {

    }

    /**
     * An override function that is called when the request is complete.
     */
    override fun onRequestComplete() {

    }

    /**
     * It shows a toast message with the error message.
     *
     * @param message The message to be displayed in the Toast.
     */
    override fun onRequestError(message: Int) {

    }

    /**
     * It shows a toast message when there is no internet connection.
     */
    override fun onConnectionAbsence() {

        showSettingsMessage(
            requireContext(), { dialog, which ->
                dialog.dismiss()
                startActivity(Intent(Settings.ACTION_WIRELESS_SETTINGS))
            },
            getString(com.example.officeapp.R.string.no_internet_connection),
            getString(com.example.officeapp.R.string.check_network_settings)
        )
    }

     private fun showSettingsMessage(
        context: Context,
        positiveListener: DialogInterface.OnClickListener?,
        vararg permissions: String?
    ) {
        val alertDialog: AlertDialog = AlertDialog.Builder(activity)
            .setCancelable(true)
            .setTitle(permissions[0])
            .setMessage(permissions[1])
            .setPositiveButton(com.example.officeapp.R.string.open, positiveListener)
            .setNegativeButton(
                com.example.officeapp.R.string.action_cancel
            ) { dialog, which -> activity?.finish() }
            .create()
        alertDialog.setCanceledOnTouchOutside(false)
        if (!activity?.isDestroyed!!) alertDialog.show()
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
        val gmmIntentUri =
            Uri.parse("geo:0,0?q=${lon},${lat}")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }
}

