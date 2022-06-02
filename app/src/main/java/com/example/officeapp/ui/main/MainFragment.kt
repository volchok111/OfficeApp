package com.example.officeapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.officeapp.adapter.Adapter
import com.example.officeapp.databinding.FragmentMainBinding
import com.example.officeapp.model.company.CompanyModel
import com.example.officeapp.ui.home.HomeFragment

class MainFragment : HomeFragment(), MainView {

    /* A way to avoid null checks on the binding object. */
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val adapter by lazy { Adapter() }

    /* A Moxy annotation that allows you to inject a presenter into a view. */
    @InjectPresenter
    lateinit var mainPresenter: MainPresenter


    /**
     * `onCreateView` is a function that returns a View
     *
     * @param inflater The LayoutInflater object that can be used to inflate any views in the fragment,
     * @param container The parent view that the fragment's UI should be attached to.
     * @param savedInstanceState A Bundle object containing the activity's previously saved state. If
     * the activity has never existed before, the value of the Bundle object is null.
     * @return The root view of the fragment.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(layoutInflater)
        binding.recyclerView.adapter = adapter

        return binding.root
    }

    /**
     * A function that is called when the view is created.
     *
     * @param view View - The view that was created
     * @param savedInstanceState If the fragment is being re-created from a previous saved state, this
     * is the state.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context?.let { mainPresenter.startInitialization(it) }
    }

    /**
     * `companies` is a `List<CompanyModel>` and `adapter.newList` expects an `ArrayList<CompanyModel>`
     *
     * @param companies List<CompanyModel>
     */
    override fun onListSetup(companies: List<CompanyModel>) {
        adapter.newList(companies as ArrayList<CompanyModel> /* = java.util.ArrayList<com.example.officeapp.model.company.CompanyModel> */)
    }

    /**
     * It adds a company to the list.
     *
     * @param company CompanyModel - This is the model that will be added to the list.
     */
    override fun addCompany(company: CompanyModel) {
        adapter.addList(company)
    }

    /**
     * It destroys the view and disposes the presenter.
     */
    override fun onDestroyView() {
        _binding = null
        mainPresenter.dispose()
        super.onDestroyView()
    }

}