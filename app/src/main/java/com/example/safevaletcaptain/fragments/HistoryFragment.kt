package com.example.safevaletcaptain.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.safevaletcaptain.R
import com.example.safevaletcaptain.adapters.CarAdapter
import com.example.safevaletcaptain.adapters.HistoryAdapter
import com.example.safevaletcaptain.databinding.FragmentHomeBinding
import com.example.safevaletcaptain.databinding.HistoryBinding

class HistoryFragment: BaseFragment<HistoryBinding>(), View.OnClickListener {

    private var navController: NavController? = null
    private var historyAdapter: HistoryAdapter? = null

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): HistoryBinding {
        return HistoryBinding.inflate(inflater, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)


        historyAdapter = HistoryAdapter(arrayListOf("aya", "lolo", "batta"), requireContext())
        val layoutManager = LinearLayoutManager(context)
        binding.historyItems.layoutManager = layoutManager
        binding.historyItems.adapter = historyAdapter

    }


    override fun onClick(v: View?) {
        when (v?.id) {


        }
    }
}