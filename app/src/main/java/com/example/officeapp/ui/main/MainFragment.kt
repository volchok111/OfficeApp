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
        _binding = FragmentMainBinding.inflate(layoutInflater)
        binding.recyclerView.adapter = adapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context?.let { mainPresenter.startInitialization(it) }
    }

    override fun onListSetup(companies: List<CompanyModel>) {
        adapter.newList(companies as ArrayList<CompanyModel> /* = java.util.ArrayList<com.example.officeapp.model.CompanyModel> */)
    }

    override fun addCompany(company: CompanyModel) {
        adapter.addList(company)
    }

    override fun onDestroyView() {
        _binding = null
        mainPresenter.dispose()
        super.onDestroyView()
    }

}