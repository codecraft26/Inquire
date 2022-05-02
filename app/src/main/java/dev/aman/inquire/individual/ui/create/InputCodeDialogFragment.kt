package dev.aman.inquire.individual.ui.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResult
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dev.aman.inquire.databinding.FragmentInputCodeDialogBinding
import dev.aman.inquire.utils.Constants


class InputCodeDialogFragment : BottomSheetDialogFragment(){

    private lateinit var binding: FragmentInputCodeDialogBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInputCodeDialogBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonDone.setOnClickListener {
            if (binding.textFieldInputCode.editText?.text.isNullOrEmpty()) {
                binding.textFieldInputCode.error = "Code cannot be empty"
            } else {
                setFragmentResult(Constants.KEY_INPUT_CODE_DIALOG, Bundle().apply {
                    putString(
                        Constants.KEY_CODE,
                        binding.textFieldInputCode.editText?.text.toString()
                    )
                })
                dismiss()
            }

            binding.buttonCancel.setOnClickListener {
                dismiss()
            }
        }


    }
}