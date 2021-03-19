package com.example.fourplaytest.activities

import android.app.ActionBar.DISPLAY_SHOW_CUSTOM
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fourplaytest.adapters.InspirationAdapter
import com.example.fourplaytest.adapters.ThemeAdapter
import com.example.fourplaytest.models.Article
import com.example.fourplaytest.viewmodelsfactories.DataViewModelFactory
import com.example.fourplaytest.R
import com.example.fourplaytest.adapters.AuthorAdapter
import com.example.fourplaytest.adapters.NewsHeading
import com.example.fourplaytest.adapters.SliderAdapter
import com.example.fourplaytest.fragments.HomeFragment
import com.example.fourplaytest.viewmodels.DataViewModel
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



    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                val homeFragment = HomeFragment.newInstance()
                openFragment(homeFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_cat -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_shopping -> {

                return@OnNavigationItemSelectedListener true
            }
        }
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
            actionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
            actionBar?.setDisplayShowCustomEnabled(true)
            actionBar?.setCustomView(R.layout.action_bar)

        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)



    } }
