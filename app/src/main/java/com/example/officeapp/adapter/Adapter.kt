package com.example.officeapp.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.officeapp.R
import com.example.officeapp.model.CompanyModel

class Adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var companyList = arrayListOf<CompanyModel>()

    fun newList(list: ArrayList<CompanyModel>){
        companyList = list
        notifyDataSetChanged()
    }

    fun addList(company: CompanyModel){
        companyList.add(company)
        notifyDataSetChanged()
    }

    class CompanyViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val name = view.findViewById<TextView>(R.id.item_name)
        private val address = view.findViewById<TextView>(R.id.item_address)
        private val number = view.findViewById<TextView>(R.id.item_number)

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return CompanyViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CompanyViewHolder)
            holder.bind(companyList[position])
    }

    override fun getItemCount(): Int {
        return companyList.count()
    }

}