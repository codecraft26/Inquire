package dev.aman.inquire.individual.ui.home.description

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dev.aman.inquire.R
import dev.aman.inquire.databinding.FragmentFeedsDescriptionBinding
import dev.aman.inquire.individual.data.InquireViewModel

class FeedsDescriptionFragment : BottomSheetDialogFragment() {
private lateinit var binding: FragmentFeedsDescriptionBinding
    private val model by activityViewModels<DescriptionViewModel>()
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
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return (super.onCreateDialog(savedInstanceState) as BottomSheetDialog).apply {
            setOnShowListener {
                behavior.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args: FeedsDescriptionFragmentArgs by navArgs()
        model.getInquireById(args.inquireId)







    }


}