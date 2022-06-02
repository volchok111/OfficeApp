package com.example.officeapp.api

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.example.officeapp.model.company.Companies
import com.example.officeapp.model.texts.Texts
import com.example.officeapp.network.HttpRetrofit
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ApiServiceImpl: ApiService {

    private val httpRetrofit: HttpRetrofit = HttpRetrofit

    /**
     * It checks if the device has internet connectivity.
     *
     * @param context The context of the activity or fragment.
     * @return Boolean
     */


    /**
     * It checks if the device has internet connectivity.
     *
     * @param context The context of the activity or fragment.
     * @return Boolean
     */
    override fun hasPing(context: Context): Boolean {
        val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val nw = manager.activeNetwork ?: return false
        val actNw = manager.getNetworkCapabilities(nw)
        if (actNw != null){
            return actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) || actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
        }
        return true
    }

    /**
     * It returns an observable of type Companies.
     *
     * @return Observable<Companies>
     */
    override fun getCompany(): Observable<Companies> {
        return httpRetrofit.getHttpApi().getCompanies()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
    }

    /**
     * It returns an observable of type Texts.
     *
     * @return Observable<Texts>
     */
    override fun getText(): Observable<Texts> {
        return httpRetrofit.getHttpApi().getText()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
    }


}