package dev.aman.inquire.individual.ui.Home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import dev.aman.inquire.individual.ui.Home.articles.ArticlesFragment
import dev.aman.inquire.individual.ui.Home.feeds.FeedsFragment
import dev.aman.inquire.individual.ui.Home.recent.RecentFragment

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