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
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dev.aman.inquire.R
import dev.aman.inquire.databinding.FragmentFeedsDescriptionBinding
import dev.aman.inquire.individual.data.InquireViewModel
import dev.aman.inquire.individual.data.model.Inquire
import io.github.kbiakov.codeview.adapters.Options
import io.github.kbiakov.codeview.highlight.ColorTheme

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
        binding = FragmentFeedsDescriptionBinding.inflate(inflater, container, false)
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
        var id = args.inquireId
        Firebase.firestore.collection("posts").document(id).get().addOnSuccessListener {
            Log.d("TAG", it.data.toString())
            if (it.data != null) {
                Log.d("Firestore", it.data.toString())
                for (documentChange in it.data!!.entries) {
                    Log.d("TAG", documentChange.value.toString())
                    if (documentChange.key == "description") {
                        binding.textViewSnippetDescription.text = documentChange.value.toString()
                    }
                    if (documentChange.key == "title") {
                        binding.textViewSnippetTitle.text=documentChange.value.toString()
                    }
                    if (documentChange.key == "image") {
                        if(documentChange.value.toString()!=""){
                            binding.imageViewSnippetOutputImage.visibility=View.INVISIBLE
                        }


                        Glide.with(this).load(documentChange.value.toString()).into(binding.imageViewSnippetOutputImage)


                    }
                    if(documentChange.key=="inquire_code"){
                        var  code=documentChange.value.toString()
                        binding.codeViewSnippetCode.apply {
                            setOptions(Options.Default.get(requireContext()).withTheme(ColorTheme.MONOKAI))
                            setCode(code ?: "An error occurred while loading the code!")
                        }
                        if(documentChange.key=="language"){
                            binding.languageChip.text=documentChange.value.toString()
                        }

                    }
                }
                binding.buttonCopyCode.setOnClickListener {

                }


            }

        }


    }
}