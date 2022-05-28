package dev.aman.inquire.individual.ui.home.description

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import dev.aman.inquire.R
import dev.aman.inquire.databinding.FragmentFeedsDescriptionBinding

class FeedsDescriptionFragment : Fragment() {
private lateinit var binding: FragmentFeedsDescriptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentFeedsDescriptionBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args by navArgs<FeedsDescriptionFragmentArgs>()
        Log.d("FeedsDescriptionFragment", "Received ID: ${args.inquireId}")
    }
}