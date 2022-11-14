package com.example.safevaletcaptain.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.safevaletcaptain.R
import com.example.safevaletcaptain.adapters.CarAdapter
import com.example.safevaletcaptain.databinding.FragmentHomeBinding
import com.google.zxing.integration.android.IntentIntegrator


class HomeFragment: BaseFragment<FragmentHomeBinding>(), View.OnClickListener {

    private var navController: NavController? = null
    private var carAdapter: CarAdapter? = null
    private var res: String? = null

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        binding.showMyQRImg.setOnClickListener(this)


        carAdapter = CarAdapter(arrayListOf("aya", "lolo", "batta", res.toString()), requireContext())
        val layoutManager = LinearLayoutManager(context)
        binding.carItems.layoutManager = layoutManager
        binding.carItems.adapter = carAdapter

    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.showMyQRImg -> {
                run {
                    IntentIntegrator(requireActivity()).initiateScan()
                }

            }


        }
    }


//    @Deprecated("Deprecated in Java")
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//
//        var result: IntentResult? = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
//
//        if(result != null){
//
//            if(result.contents != null){
//                binding.showQr.text = result.contents
//                res = result.contents
//            } else {
//                binding.showQr.text = "scan failed"
//            }
//        } else {
//            super.onActivityResult(requestCode, resultCode, data)
//        }
//    }


//    @Deprecated("Deprecated in Java")
//    override fun onActivityResult(requestCode: Int, resultCode: Int, @Nullable data: Intent?) {
//        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
//        if (result != null) {
//            if (result.contents == null) {
//                Toast.makeText(context, "Cancelled", Toast.LENGTH_LONG).show()
//            } else {
//                Toast.makeText(context, "Scanned : " + result.contents, Toast.LENGTH_LONG).show()
//            }
//        }
//    }


}