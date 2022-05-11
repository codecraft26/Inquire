package dev.aman.inquire.individual.ui.create.form

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import dev.aman.inquire.databinding.FragmentAddDetailsBinding
import dev.aman.inquire.individual.data.daos.InquireDao
import dev.aman.inquire.individual.ui.create.CreateFragment
import dev.aman.inquire.utils.Constants


class AddDetailsFragment : Fragment() {
    private lateinit var binding: FragmentAddDetailsBinding
    private val model by activityViewModels<InquireDao>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadView()

    }

    private fun loadView() {
        binding.textFieldSnippetTitle.editText?.doOnTextChanged { text, _, _, _ ->
            binding.textFieldSnippetTitle.error = if (text.isNullOrBlank()) {
                "Title is required"
            } else {
                null
            }
            model.title= text.toString()

        }

        binding.textFieldSnippetDescription.editText?.doOnTextChanged { text, _, _, _ ->
            binding.textFieldSnippetDescription.error = if (text.isNullOrBlank()) {
                "Description is required"
            } else {
                null
            }
            model.description= text.toString()

        }


        binding.textFieldSnippetTags.editText?.doOnTextChanged { text, _, _, _ ->
            binding.textFieldSnippetTags.error = if (text.isNullOrBlank()) {
                "Language  are required"
            } else {
                null
            }
            model.language= text.toString()
        }




        binding.addDetailsButtonNext.setOnClickListener{
           if (binding.textFieldSnippetTitle.editText?.text.isNullOrBlank() ||
               binding.textFieldSnippetDescription.editText?.text.isNullOrBlank() ||
               binding.textFieldSnippetTags.editText?.text.isNullOrBlank()
           ){
               Toast.makeText(context,"Please fill all the fields",Toast.LENGTH_SHORT).show()
           }else{
               (parentFragment as? CreateFragment)?.nextPage()

           }
        }
    }
}

