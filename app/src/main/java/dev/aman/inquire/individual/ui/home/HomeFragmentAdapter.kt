package dev.aman.inquire.individual.ui.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import dev.aman.inquire.individual.ui.home.articles.ArticlesFragment
import dev.aman.inquire.individual.ui.home.feeds.FeedsFragment
import dev.aman.inquire.individual.ui.home.recent.RecentFragment

class HomeFragmentAdapter(fragment: Fragment): FragmentStateAdapter(fragment){
    override fun getItemCount() = 3
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FeedsFragment()
            1 -> ArticlesFragment()
            2-> RecentFragment()
            else -> FeedsFragment()
        }
    }

}