package com.example.officeapp.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.officeapp.R
import com.example.officeapp.model.company.CompanyModel

class Adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var companyList = arrayListOf<CompanyModel>()

    /**
     * It updates the list of companies in the adapter.
     *
     * @param list ArrayList<CompanyModel> - This is the list of companies that you want to display in
     * the recycler view.
     */
    fun newList(list: ArrayList<CompanyModel>){
        companyList = list
        notifyDataSetChanged()
    }

    /**
     * It adds a company to the list and notifies the adapter that the data has changed.
     *
     * @param company CompanyModel - This is the data that will be added to the list.
     */
    fun addList(company: CompanyModel){
        companyList.add(company)
        notifyDataSetChanged()
    }

    class CompanyViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val name = view.findViewById<TextView>(R.id.item_name)
        private val address = view.findViewById<TextView>(R.id.item_address)
        private val number = view.findViewById<TextView>(R.id.item_number)

        /**
         * The function takes a CompanyModel object as a parameter and sets the text of the TextViews
         * to the values of the CompanyModel object
         *
         * @param company CompanyModel - This is the data that will be bound to the view.
         */
        fun bind(company: CompanyModel){
            name.text = company.name
            address.text = company.addresses[0].street
            number.text = company.phone
            itemView.setOnClickListener {
                val bundle = Bundle()
                bundle.putSerializable("company_model",company)
                itemView.findNavController().navigate(
                    R.id.action_mainFragment_to_detailFragment,bundle
                )
            }
        }
    }

    /**
     * This function is called when the RecyclerView needs a new RecyclerView.ViewHolder of the given
     * type to represent an item
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to an
     * adapter position.
     * @param viewType This is the type of the view. It is used when you have multiple view types in
     * your RecyclerView.
     * @return A RecyclerView.ViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return CompanyViewHolder(view)
    }

    /**
     * It binds the data to the view holder.
     *
     * @param holder RecyclerView.ViewHolder - The ViewHolder that should be updated to represent the
     * contents of the item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CompanyViewHolder)
            holder.bind(companyList[position])
    }

    /**
     * The function returns the number of items in the companyList
     *
     * @return The number of items in the companyList
     */
    override fun getItemCount(): Int {
        return companyList.count()
    }

}