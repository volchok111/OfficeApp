package com.example.officeapp.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.officeapp.databinding.FragmentDetailBinding
import com.example.officeapp.model.company.CompanyModel
import com.example.officeapp.ui.home.HomeFragment


class DetailFragment :HomeFragment(), DetailView {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var company: CompanyModel

    /* A Moxy annotation that injects the presenter into the view. */
    @InjectPresenter
    lateinit var detailPresenter: DetailPresenter


    /**
     * It gets the company model from the arguments bundle.
     *
     * @param savedInstanceState The saved state of the fragment, if any.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        company = arguments?.getSerializable("company_model") as CompanyModel
    }

    /**
     * This function is called when the fragment is created
     *
     * @param inflater The LayoutInflater object that can be used to inflate any views in the fragment,
     * @param container The parent view that the fragment's UI should be attached to.
     * @param savedInstanceState This is a Bundle object that contains the activity's previously saved
     * state. If the activity has never existed before, the value of the Bundle object is null.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(layoutInflater)
        binding.apply {
            fragmentDetailNameTv.text = company.name
            fragmentDetailStreet.text = company.addresses[0].street
            fragmentDetailCity.text = company.addresses[0].city
            fragmentDetailZipcode.text = company.addresses[0].zipcode
            fragmentDetailContactName.text = company.contact.firstname
            fragmentDetailContactLastName.text = company.contact.lastname
            fragmentDetailContactNumber.text = company.contact.phone
            fragmentDetailContactEmail.text = company.contact.email
            fragmentDetailContactStreet.text = company.contact.address.street
            fragmentDetailContactCity.text = company.contact.address.city
            fragmentDetailContactZipcode.text = company.contact.address.zipcode

            /* Calling the `onMakeCall` method from the `HomeFragment` class. */
            callFab.setOnClickListener {
                onMakeCall(company.phone)
            }

            /* Calling the `onSendEmail` method from the `HomeFragment` class. */
            emailFab.setOnClickListener {
                onSendEmail(company.email,"My test application")
            }

            /* Calling the `onShowMap` method from the `HomeFragment` class. */
            navigateFab.setOnClickListener {
                company.addresses[0].apply {
                    onShowMap(latitude.toString(),longitude.toString())
                }

            }
        }


        return binding.root


    }

    /**
     * The function is called when the view is created
     *
     * @param view View - The view returned by onCreateView(LayoutInflater, ViewGroup, Bundle)
     * @param savedInstanceState A Bundle object containing the activity's previously saved state. If
     * the activity has never existed before, the value of the Bundle object is null.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailPresenter.getDescription(requireContext())
    }

    /**
     * It destroys the view.
     */
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    /**
     * The function is called when the data is loaded from the network. The data is then set to the
     * text view
     *
     * @param data The data that was loaded from the API.
     */
    override fun onDescriptionLoaded(data: String) {
        binding.fragmentDetailDescriptionTv.text = data
    }


}