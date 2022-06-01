package com.example.officeapp.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.officeapp.R
import com.example.officeapp.adapter.Adapter
import com.example.officeapp.databinding.FragmentMainBinding
import com.example.officeapp.model.CompanyModel
import com.example.officeapp.ui.home.HomeFragment

class MainFragment : HomeFragment(), MainView {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val adapter by lazy { Adapter() }

    @InjectPresenter
    lateinit var mainPresenter: MainPresenter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onListSetup(companies: List<CompanyModel>) {
        TODO("Not yet implemented")
    }

    override fun addCompany(company: CompanyModel) {
        TODO("Not yet implemented")
    }

}