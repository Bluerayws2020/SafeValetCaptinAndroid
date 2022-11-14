package com.example.safevaletcaptain.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.safevaletcaptain.databinding.ChooseLanguageBinding

class LanguageFragment: BaseFragment<ChooseLanguageBinding>(), View.OnClickListener {


    private var navController: NavController? = null

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ChooseLanguageBinding {
        return ChooseLanguageBinding.inflate(inflater, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}