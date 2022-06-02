package com.example.officeapp.ui.detail

import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.officeapp.ui.home.HomeView

/* A Moxy annotation that tells the view to use the SingleStateStrategy. */
@StateStrategyType(SingleStateStrategy::class)
interface DetailView: HomeView {

    /**
     * It takes a string as an argument and returns nothing
     *
     * @param data The description of the video.
     */
    fun onDescriptionLoaded(data: String)
}