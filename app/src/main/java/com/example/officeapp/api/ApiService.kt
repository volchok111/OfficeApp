package com.example.officeapp.api

import android.content.Context
import com.example.officeapp.model.company.Companies
import com.example.officeapp.model.texts.Texts
import io.reactivex.Observable

/* The ApiService interface is used to define the methods that will be used to make API calls. */
interface ApiService {
    fun hasPing(context: Context): Boolean
    fun getCompany(): Observable<Companies>
    fun getText(): Observable<Texts>
}