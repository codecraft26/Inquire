package dev.aman.inquire.individual.ui.bookmarked

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.aman.inquire.databinding.FragmentBookmarkedBinding


class BookmarkedFragment : Fragment() {
    private lateinit var binding: FragmentBookmarkedBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBookmarkedBinding.inflate(inflater, container, false)
        return binding.root
    }
}