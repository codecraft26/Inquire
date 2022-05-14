package dev.aman.inquire.individual.ui.create.form

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResultListener
import com.google.android.material.snackbar.Snackbar
import com.google.modernstorage.permissions.RequestAccess
import com.google.modernstorage.permissions.StoragePermissions
import com.google.modernstorage.storage.AndroidFileSystem
import com.google.modernstorage.storage.toOkioPath
import dev.aman.inquire.databinding.FragmentAddCodeBinding
import dev.aman.inquire.individual.data.InquireViewModel
import dev.aman.inquire.individual.ui.create.InputCodeDialogFragment
import dev.aman.inquire.utils.Constants


import okio.buffer


class AddCodeFragment : Fragment() {

private lateinit var binding:FragmentAddCodeBinding
    private val model by activityViewModels<InquireViewModel>()
    private lateinit var fileSystem: AndroidFileSystem

    private val requestFile =
        registerForActivityResult(ActivityResultContracts.OpenDocument()) { uri ->
            if (uri != null) {
                model.inquire_code = fileSystem.source(uri.toOkioPath()).buffer().readUtf8().also {
                    binding.codeViewSnippetCode.apply {

                        setCode(it)
                    }
                }
            }
        }

    private val requestStorageAccess = registerForActivityResult(RequestAccess()) { hasAccess ->
        if (!hasAccess) {
            requestFile.launch(arrayOf("text/*"))
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
     binding= FragmentAddCodeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // auto language recognition
        fileSystem = AndroidFileSystem(requireContext())
        setFragmentResultListener(Constants.KEY_INPUT_CODE_DIALOG) { _, bundle ->
            val code = bundle.getString(Constants.KEY_CODE)
            if (code != null) {
                model.inquire_code = code
            }
            binding.codeViewSnippetCode.apply {


                if (code != null) {
                    setCode(code)
                }


            }
        }


        binding.buttonInputCode.setOnClickListener {
            InputCodeDialogFragment().show(parentFragmentManager, "INPUT_MODAL")

        }
        binding.buttonSelectFileFromDevice.setOnClickListener{
            requestStorageAccess.launch(
                RequestAccess.Args(
                    action = StoragePermissions.Action.READ,
                    types = listOf(StoragePermissions.FileType.Document),
                    createdBy = StoragePermissions.CreatedBy.AllApps
                )
            )
        }
       binding.publishButton.setOnClickListener {
        model.publishInquire()
       }
       }



        }


