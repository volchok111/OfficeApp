package com.example.officeapp.ui.main

import android.content.Context
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.officeapp.R
import com.example.officeapp.api.ApiServiceImpl
import com.example.officeapp.model.CompanyModel
import io.reactivex.disposables.CompositeDisposable

@InjectViewState
class MainPresenter: MvpPresenter<MainView>() {
    private val apiService = ApiServiceImpl()
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()


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