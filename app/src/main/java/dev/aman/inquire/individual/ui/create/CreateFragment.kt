package dev.aman.inquire.individual.ui.create

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import dev.aman.inquire.databinding.FragmentCreateBinding
import dev.aman.inquire.individual.ui.create.form.AddCodeFragment
import dev.aman.inquire.individual.ui.create.form.AddDetailsFragment
import dev.aman.inquire.individual.ui.create.form.AddImageFragment
import dev.aman.inquire.utils.DepthPageTransformer


class CreateFragment : Fragment() {
    private lateinit var binding: FragmentCreateBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCreateBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.formPager.adapter = ScreenSlidePagerAdapter(this)
        binding.formPager.isUserInputEnabled = false
        binding.formPager.setPageTransformer(DepthPageTransformer())
    }


    fun nextPage() {
        binding.formPager.currentItem = binding.formPager.currentItem + 1
    }
    private class ScreenSlidePagerAdapter(fa: Fragment) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment = when (position) {
            0 -> AddDetailsFragment()
            1 -> AddImageFragment()
            2 -> AddCodeFragment()
            else -> {
                throw IllegalArgumentException("Invalid position")
            }
        }
    }
}



