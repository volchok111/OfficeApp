package com.example.officeapp.ui.main

import android.content.Context
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.officeapp.R
import com.example.officeapp.api.ApiServiceImpl
import com.example.officeapp.model.company.CompanyModel
import io.reactivex.disposables.CompositeDisposable

/* A Moxy annotation that allows to inject the view state into the presenter. */
@InjectViewState
class MainPresenter: MvpPresenter<MainView>() {
    private val apiService = ApiServiceImpl()
    /* A variable that is used to dispose of the request. */
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()


    /**
     * It checks if the dataList is empty, if it is, it checks if the device has internet connection,
     * if it does, it makes a request to the server and sets up the list
     *
     * @param context Context - context of the application
     * @return The method returns a list of companies.
     */
    fun startInitialization(context: Context){
        if (dataList.isNotEmpty()){
            viewState.onListSetup(dataList)
            return
        }
        context.let {
            if (!apiService.hasPing(context)){
                viewState.onConnectionAbsence()
            }
        }
        compositeDisposable.add(
            apiService.getCompany()
                .subscribe({company ->
                    viewState.onListSetup(company.data)
                },
                    {
                        viewState.onRequestError(R.string.error)
                    })
        )
    }

    fun dispose(){
        compositeDisposable.dispose()
    }

    companion object{
        private val dataList = ArrayList<CompanyModel>()
    }
}