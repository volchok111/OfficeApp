package com.example.officeapp.network

import com.example.officeapp.model.company.Companies
import com.example.officeapp.model.texts.Texts
import io.reactivex.Observable
import retrofit2.http.GET

interface HttpApi {

    /**
     * This function will return an Observable of type Companies
     */
    @GET("companies?_quantity=20&_seed=123456")
    fun getCompanies(): Observable<Companies>

    /**
     * This function will return an Observable of type Texts
     */
    @GET("texts?_quantity=1&_characters=500")
    fun getText(): Observable<Texts>



}