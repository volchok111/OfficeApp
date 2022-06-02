package com.example.officeapp.ui.main

import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.officeapp.model.company.CompanyModel
import com.example.officeapp.ui.home.HomeView

/* This is a Moxy annotation that tells the view to only use the most recent state. */
@StateStrategyType(SingleStateStrategy::class)
interface MainView: HomeView {

    /**
     * When the list of companies is set up, do this.
     *
     * @param companies List<CompanyModel> - This is the list of companies that you will be using to
     * populate your list.
     */
    fun onListSetup(companies: List<CompanyModel>)

    /**
     * This function adds a company to the database.
     *
     * @param company CompanyModel
     */
    fun addCompany(company: CompanyModel)
}