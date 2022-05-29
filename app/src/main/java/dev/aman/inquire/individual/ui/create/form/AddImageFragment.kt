package dev.aman.inquire.individual.ui.create.form

import android.app.Activity
import android.content.Intent
import android.os.Build.VERSION_CODES.P
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.activityViewModels
import com.github.dhaval2404.imagepicker.ImagePicker
import com.github.dhaval2404.imagepicker.ImagePicker.Companion.REQUEST_CODE
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import dev.aman.inquire.databinding.FragmentAddImageBinding
import dev.aman.inquire.individual.data.InquireViewModel
import dev.aman.inquire.individual.ui.create.CreateFragment
import java.util.*


class AddImageFragment : Fragment() {
    private lateinit var binding: FragmentAddImageBinding
    val fileName = UUID.randomUUID().toString() +".jpg"
    val refStorage = Firebase.storage.reference.child("images/$fileName")

    private val model by activityViewModels<InquireViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddImageBinding.inflate(inflater, container, false)
        return binding.root
    }

    private val startForImageResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            val resultCode = result.resultCode
            val data = result.data
            if (resultCode == Activity.RESULT_OK) {

                val ImageUri=data?.data

                val uploadTask = refStorage.putFile(ImageUri!!)
                try {
                    val url = uploadTask.continueWithTask { task ->
                        if (!task.isSuccessful) {
                            task.exception?.let {
                                throw it
                            }
                        }
                        refStorage.downloadUrl
                    }.addOnCompleteListener {
                        if (it.isSuccessful) {
                            val publicDownloadUrl = it.result
                            // Here we have the URL
                            model.imageUri= publicDownloadUrl.toString()

                        }
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }

                binding.imageViewResult.setImageURI(ImageUri)
                Toast.makeText(context, "Image Selected", Toast.LENGTH_SHORT).show()
                if (resultCode == Activity.RESULT_CANCELED) {
                    // User cancelled the image capture
                    Toast.makeText(context, "User cancelled the image capture", Toast.LENGTH_SHORT)
                        .show()

                }
            }
        }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageViewPickCamera.setOnClickListener {
            ImagePicker.with(this@AddImageFragment)
                .cameraOnly()
                .crop()
                .compress(1024)
                .maxResultSize(1080, 1080)
                .createIntent { startForImageResult.launch(it) }
        }

        binding.imageViewPickGallery.setOnClickListener {
            ImagePicker.with(this@AddImageFragment)
                .galleryOnly()
                .crop()
                .compress(1024)
                .maxResultSize(1080, 1080)
                .createIntent { startForImageResult.launch(it) }
        }

        binding.buttonNext.setOnClickListener {
            (parentFragment as CreateFragment).nextPage()
        }
        binding.videoPicker.setOnClickListener{
            val intent = Intent()
            intent.type = "video/*"
            intent.action = Intent.ACTION_PICK
            startActivityForResult(Intent.createChooser(intent, "Select Video"),REQUEST_CODE)
        }
    }
}