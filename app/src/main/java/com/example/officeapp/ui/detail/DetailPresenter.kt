package com.example.officeapp.ui.detail

import android.annotation.SuppressLint
import android.content.Context
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.officeapp.R
import com.example.officeapp.api.ApiServiceImpl
import kotlin.random.Random

/* A Moxy annotation. It is used to inject the view state into the presenter. */
@InjectViewState
class DetailPresenter : MvpPresenter<DetailView>() {
    private val apiService = ApiServiceImpl()

    /**
     * It gets a random text from the server.
     *
     * @param context Context - context of the activity
     */
    @SuppressLint("CheckResult")
    fun getDescription(context: Context) {
        if (apiService.hasPing(context)){
            apiService.getText()
                .subscribe({
                    val idx = Random.nextInt(0,it.data.size)
                           val data = it.data[idx].content
                    viewState.onDescriptionLoaded(data)
                },{
                    viewState.onRequestError(R.string.error)
                })
        }
        else viewState.onConnectionAbsence()
    }

}