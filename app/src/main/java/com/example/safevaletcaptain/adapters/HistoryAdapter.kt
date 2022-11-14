package com.example.safevaletcaptain.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.safevaletcaptain.databinding.CarItemsBinding
import com.example.safevaletcaptain.databinding.HistoryItemsBinding

class HistoryAdapter(private val list: ArrayList<String>, val context: Context): RecyclerView.Adapter<HistoryAdapter.Holder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        val binding =
            HistoryItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)

    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.binding.whiteMyCar.text = list[position]
    }

    override fun getItemCount(): Int {
        return 3
    }


    class Holder(val binding: HistoryItemsBinding) : RecyclerView.ViewHolder(binding.root)


}