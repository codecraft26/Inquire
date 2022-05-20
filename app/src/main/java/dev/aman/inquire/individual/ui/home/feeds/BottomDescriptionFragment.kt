package dev.aman.inquire.individual.ui.home.feeds

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.aman.inquire.R
import dev.aman.inquire.databinding.FragmentBottomDescriptionBinding


class BottomDescriptionFragment : Fragment() {

    private lateinit var binding:FragmentBottomDescriptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom_description, container, false)

    }



}