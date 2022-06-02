package com.example.officeapp.network

import com.example.officeapp.model.company.Companies
import com.example.officeapp.model.texts.Texts
import io.reactivex.Observable
import retrofit2.http.GET

interface HttpApi {

    /**
     * This function will return an Observable of type Companies
     */
    @GET("companies")
    fun getCompanies(): Observable<Companies>

    /**
     * This function will return an Observable of type Texts
     */
    @GET("texts")
    fun getText(): Observable<Texts>



}