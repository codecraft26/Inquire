package dev.aman.inquire.individual.ui.profile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import dev.aman.inquire.R
import dev.aman.inquire.databinding.FragmentAccountBinding
import dev.aman.inquire.individual.IndividualMainActivity
import dev.aman.inquire.individual.data.InquireViewModel
import dev.aman.inquire.individual.data.model.User
import dev.aman.inquire.individual.ui.login.IndividualLoginActivity


class AccountFragment : Fragment() {
    private lateinit var binding: FragmentAccountBinding

    private val model by activityViewModels<ProfileViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textViewUserEmail.text = model.email
        binding.textViewUserName.text = model.name
        Glide.with(this).load(model.photo).circleCrop().into(binding.imageViewUserImage)
        /*  binding.textViewUserBio.text=model.bio*/
        model.success.observe(viewLifecycleOwner) {

            if (it) {
                    binding.textViewUserBio.text = model.bio
                    binding.textViewUserName.text = model.name
                        binding.textViewUserEmail.text = model.email
                    binding.githubLink.text = model.github_Username


                }

            }



        model.getData()
        binding.logoutButton.setOnClickListener {
            model.logout()
            val intent = Intent(context, IndividualLoginActivity::class.java)
            startActivity(intent)
               (activity as IndividualMainActivity).finish()



        }




    }
}

