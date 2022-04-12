package dev.aman.inquire.individual.ui.home.feeds

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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



}