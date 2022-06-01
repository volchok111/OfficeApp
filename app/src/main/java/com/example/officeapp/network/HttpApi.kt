package com.example.officeapp.network

import com.example.officeapp.model.Companies
import io.reactivex.Observable
import retrofit2.http.GET

interface HttpApi {
//GET - https://fakerapi.it/api/v1/companies
    @GET("/companies")
    fun getCompanies(): Observable<Companies>


}