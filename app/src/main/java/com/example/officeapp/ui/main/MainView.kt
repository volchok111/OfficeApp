package com.example.officeapp.ui.main

import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.officeapp.model.CompanyModel
import com.example.officeapp.ui.home.HomeView

@StateStrategyType(SingleStateStrategy::class)
interface MainView: HomeView {

    fun onListSetup(companies: List<CompanyModel>)
    fun addCompany(company: CompanyModel)
}