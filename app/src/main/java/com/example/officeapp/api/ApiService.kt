package com.example.officeapp.api

import android.content.Context
import com.example.officeapp.model.Companies
import com.example.officeapp.model.CompanyModel
import io.reactivex.Observable

interface ApiService {
    fun hasPing(context: Context): Boolean
    fun getCompany(): Observable<Companies>
}