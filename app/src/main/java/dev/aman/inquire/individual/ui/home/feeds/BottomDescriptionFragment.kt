package dev.aman.inquire.individual.ui.home.feeds

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import dev.aman.inquire.R
import dev.aman.inquire.databinding.FragmentBottomDescriptionBinding
import dev.aman.inquire.individual.data.model.Inquire


class BottomDescriptionFragment : Fragment() {
   private lateinit var binding: FragmentBottomDescriptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBottomDescriptionBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val args by navArgs<BottomDescriptionFragmentArgs>()
        super.onViewCreated(view, savedInstanceState)
        setUpinquire(inquire = Inquire())
    }

    private fun setUpinquire(inquire: Inquire) {
        with(binding){
            textView2.text=inquire.title
        }

    }


}