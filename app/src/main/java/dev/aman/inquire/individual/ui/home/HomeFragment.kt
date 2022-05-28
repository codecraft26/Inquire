package dev.aman.inquire.individual.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import dev.aman.inquire.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        renderContent()
    }

    private fun renderContent() {
        binding.viewpager2TasksFragments.adapter = HomeFragmentAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewpager2TasksFragments) { tab, position ->
            tab.text = when (position) {
                0 -> "Feeds"

                1->"Bookmarked"

                else -> "Others"
            }
        }.attach()
    }
}
