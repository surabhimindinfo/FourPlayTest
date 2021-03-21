package com.example.fourplaytest.activities

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fourplaytest.R
import com.example.fourplaytest.adapters.*
import com.example.fourplaytest.fragments.HomeFragment
import com.example.fourplaytest.models.Article
import com.example.fourplaytest.utils.Utility
import com.example.fourplaytest.utils.Utility.showCustomDialog
import com.example.fourplaytest.utils.Utility.showErrorToast
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var listNews: MutableList<Article>
    private lateinit var listHeading: MutableList<Article>
    private lateinit var listAuthor: MutableList<Article>
    private lateinit var listInspirations: MutableList<Article>
    private lateinit var listThemes: MutableList<Article>


    private lateinit var adapter: SliderAdapter
    private lateinit var headingadapter: NewsHeading
    private lateinit var authorAdapter: AuthorAdapter
    private lateinit var inspirationAdapter: InspirationAdapter
    private lateinit var themeAdapter: ThemeAdapter


    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->

            if (item.itemId!=R.id.navigation_home)
                showCustomDialog( )
//            when (item.itemId) {
//                R.id.navigation_home -> {
//                    val homeFragment = HomeFragment.newInstance()
//                    openFragment(homeFragment)
//                    return@OnNavigationItemSelectedListener true
//                }
//                R.id.navigation_cat -> {
//
//                    return@OnNavigationItemSelectedListener true
//                }
//                R.id.navigation_shopping -> {
//                    showErrorToast("Page Unavailable")
//                    return@OnNavigationItemSelectedListener true
//                }
//                R.id.navigation_account -> {
//                    showErrorToast("Page Unavailable")
//                    return@OnNavigationItemSelectedListener true
//                }
//                R.id.navigation_room -> {
//                    showErrorToast("Page Unavailable")
//                    return@OnNavigationItemSelectedListener true
//                }
//            }
            false
        }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val actionBar: ActionBar? = this.supportActionBar
        actionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        actionBar?.setDisplayShowCustomEnabled(true)
        actionBar?.setCustomView(R.layout.action_bar)

        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val homeFragment = HomeFragment.newInstance()
        openFragment(homeFragment)


    }
}
