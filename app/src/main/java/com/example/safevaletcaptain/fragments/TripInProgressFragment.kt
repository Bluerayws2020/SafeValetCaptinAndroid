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
import com.example.safevaletcaptain.databinding.TripInProgressBinding

class TripInProgressFragment: BaseFragment<TripInProgressBinding>(), View.OnClickListener {

    private var navController: NavController? = null
    private var carAdapter: CarAdapter? = null

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): TripInProgressBinding {
        return TripInProgressBinding.inflate(inflater, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        binding.callBackMyCarImg.setOnClickListener(this)

    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.callBackMyCarImg -> {
                Navigation.findNavController(v)
                    .navigate(R.id.action_tripInProgress_to_pickCarFragment)

            }

        }
    }
}