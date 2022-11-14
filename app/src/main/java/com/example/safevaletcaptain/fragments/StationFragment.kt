package com.example.safevaletcaptain.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.safevaletcaptain.adapters.CarAdapter
import com.example.safevaletcaptain.databinding.PickUpTheCarBinding
import com.example.safevaletcaptain.databinding.StationBinding

class StationFragment: BaseFragment<StationBinding>(), View.OnClickListener {

    private var navController: NavController? = null
    private var carAdapter: CarAdapter? = null

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): StationBinding {
        return StationBinding.inflate(inflater, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

    }


    override fun onClick(v: View?) {
        when (v?.id) {
//            R.id.showMyQRImg -> {
//                Navigation.findNavController(v)
//                    .navigate(R.id.action_homeFragment_to_showMyCarFragment)

        }

    }
}