package com.example.officeapp.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.officeapp.R
import com.example.officeapp.databinding.FragmentDetailBinding
import com.example.officeapp.model.CompanyModel
import com.example.officeapp.ui.home.HomeFragment


class DetailFragment :HomeFragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var company: CompanyModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        company = arguments?.getSerializable("company_model") as CompanyModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(layoutInflater)
        binding.fragmentDetailNameTv.text = company.name
        binding.fragmentDetailStreet.text = company.addresses[0].street
        binding.fragmentDetailCity.text = company.addresses[0].city
        binding.fragmentDetailZipcode.text = company.addresses[0].zipcode
        binding.fragmentDetailContactName.text = company.contact.firstname
        binding.fragmentDetailContactLastName.text = company.contact.lastname
        binding.fragmentDetailContactNumber.text = company.contact.phone
        binding.fragmentDetailContactEmail.text = company.contact.email
        binding.fragmentDetailContactStreet.text = company.contact.address.street
        binding.fragmentDetailContactCity.text = company.contact.address.city
        binding.fragmentDetailContactZipcode.text = company.contact.address.zipcode

        return binding.root


    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }


}