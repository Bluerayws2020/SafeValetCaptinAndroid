package com.example.safevaletcaptain.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.safevaletcaptain.R
import com.example.safevaletcaptain.databinding.CarItemsBinding


class CarAdapter(private val list: ArrayList<String>, val context: Context): RecyclerView.Adapter<CarAdapter.Holder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        val binding =
            CarItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)

    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.binding.carModel.text = list[position]
        holder.binding.takeOrderBtn.setOnClickListener{
//            Navigation.findNavController(v)
//                .navigate(R.id.action_homeFragment_to_tripInProgressFragment)
            Navigation.findNavController(it)
                .navigate(R.id.action_homeFragment_to_tripInProgressFragment)
        }
    }

    override fun getItemCount(): Int {
        return 3
    }


    class Holder(val binding: CarItemsBinding) : RecyclerView.ViewHolder(binding.root)

}