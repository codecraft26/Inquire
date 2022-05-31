package dev.aman.inquire.individual.ui.home.description

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

import coil.load
import coil.transform.RoundedCornersTransformation

import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.firestore.ktx.firestore

import com.google.firebase.ktx.Firebase
import dev.aman.inquire.R

import dev.aman.inquire.databinding.FragmentFeedsDescriptionBinding
import io.github.kbiakov.codeview.adapters.Options
import io.github.kbiakov.codeview.highlight.ColorTheme

class FeedsDescriptionFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentFeedsDescriptionBinding
     lateinit var imageUri:String
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
                binding.textViewSnippetDescription.text = it.data!!["description"].toString()
                binding.textViewSnippetTitle.text = it.data!!["title"].toString()
                binding.languageChip.text = it.data!!["language"].toString()
                imageUri=it.data!!["image"].toString()
                binding.imageViewInquire.load(it.data!!["imageUri"].toString()){
                    error(R.mipmap.ic_launcher)
                    crossfade(true)
                    transformations(RoundedCornersTransformation(20f))


                }

                binding.codeViewSnippetCode.apply{
                    val code =it.data!!["inquire_code"].toString()
                    setOptions(Options.Default.get(requireContext()).withTheme(ColorTheme.MONOKAI))
                    setCode(code ?: "An error occurred while loading the code!")
                }
             binding.buttonCopyCode.setOnClickListener{


             }



            }


        }


    }
}