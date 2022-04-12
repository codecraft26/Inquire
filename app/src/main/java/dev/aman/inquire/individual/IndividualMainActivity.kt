package dev.aman.inquire.individual

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

import dev.aman.inquire.R
import dev.aman.inquire.individual.ui.bookmarked.BookmarkedFragment
import dev.aman.inquire.individual.ui.create.CreateFragment
import dev.aman.inquire.individual.ui.home.HomeFragment

class IndividualMainActivity : AppCompatActivity() {
    private lateinit var currentFragment : Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_individual_main)


        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,
            HomeFragment()
        ).commit()
        val bottomNav : BottomNavigationView = findViewById(R.id.bottom_navView)
        bottomNav.setOnNavigationItemSelectedListener(bottomListener)

    }
    val bottomListener = BottomNavigationView.OnNavigationItemSelectedListener {
        // switch between ids of menu
        when(it.itemId){
            R.id.homeFragment -> {
                currentFragment = HomeFragment()
            }
            R.id.createFragment -> {
                currentFragment = CreateFragment()
            }
            R.id.bookmarkedFragment-> {
                currentFragment = BookmarkedFragment()
            }
        }
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,currentFragment).commit()
        true
    }

}