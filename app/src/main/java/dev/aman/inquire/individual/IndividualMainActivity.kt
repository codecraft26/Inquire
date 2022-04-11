package dev.aman.inquire.individual

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.close
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

import dev.aman.inquire.R
import dev.aman.inquire.individual.ui.bookmarked.BookmarkedFragment
import dev.aman.inquire.individual.ui.create.CreateFragment
import dev.aman.inquire.individual.ui.Home.HomeFragment

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