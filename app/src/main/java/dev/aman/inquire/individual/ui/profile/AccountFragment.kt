package dev.aman.inquire.individual.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.aman.inquire.R
import dev.aman.inquire.databinding.FragmentAccountBinding


class AccountFragment : Fragment() {
    private lateinit var binding:FragmentAccountBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentAccountBinding.inflate(inflater,container,false)
        return binding.root
    }

}