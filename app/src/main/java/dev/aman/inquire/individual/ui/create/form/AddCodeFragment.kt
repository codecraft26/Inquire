package dev.aman.inquire.individual.ui.create.form

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.aman.inquire.databinding.FragmentAddCodeBinding
import dev.aman.inquire.individual.ui.create.InputCodeDialogFragment


class AddCodeFragment : Fragment() {

private lateinit var binding:FragmentAddCodeBinding




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
     binding= FragmentAddCodeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // auto language recognition
        binding.buttonInputCode.setOnClickListener {
            InputCodeDialogFragment().show(parentFragmentManager, "INPUT_MODAL")

        }
    }

}