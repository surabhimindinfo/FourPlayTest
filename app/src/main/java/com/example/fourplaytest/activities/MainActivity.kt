package com.example.fourplaytest.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
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
import com.example.fourplaytest.viewmodels.DataViewModel
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

    override fun onResume() {
        super.onResume()
        searchView.clearFocus()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        content_layout.visibility = View.GONE
        shimmerLayout.startShimmer()
        recycler_main.layoutManager =
            LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
        recycler_heading.layoutManager =
            LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
        recycler_author.layoutManager =
            LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
        recycler_inspirations.layoutManager =
            LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
        recycler_themes.layoutManager =
            LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)


        listNews = mutableListOf<Article>()
        listHeading = mutableListOf<Article>()
        listAuthor = mutableListOf<Article>()
        listInspirations = mutableListOf<Article>()
        listThemes = mutableListOf<Article>()


        adapter = SliderAdapter(
            this,
            listNews
        )

        headingadapter = NewsHeading(
            this,
            listHeading
        )
        authorAdapter = AuthorAdapter(
            this,
            listAuthor
        )
        inspirationAdapter = InspirationAdapter(
            this,
            listInspirations
        )
        themeAdapter = ThemeAdapter(
            this,
            listThemes
        )




        recycler_main.adapter = adapter
        recycler_heading.adapter = headingadapter
        recycler_author.adapter = authorAdapter
        recycler_inspirations.adapter = inspirationAdapter
        recycler_themes.adapter = themeAdapter

        ViewCompat.setNestedScrollingEnabled(recycler_themes, false)

        val dataViewModel =
            ViewModelProviders.of(this, DataViewModelFactory(this)).get(DataViewModel::class.java)
        dataViewModel.getData().observe(this, object : Observer<ArrayList<Article>> {
            override fun onChanged(t: ArrayList<Article>?) {

                shimmerLayout.stopShimmer()
                shimmerLayout.visibility = View.GONE
                content_layout.visibility = View.VISIBLE

                listNews.clear()
                t?.let {
                    listNews.add(it.get(0))
                    listNews.add(it.get(1))
                }
                adapter.notifyDataSetChanged()

                listHeading.clear()
                t?.let {

                    for (i in 2..5)
                        listHeading.add(it.get(i))
                }
                headingadapter.notifyDataSetChanged()
                listAuthor.clear()
                t?.let {

                    try {

                        for (i in 6..10)
                            listAuthor.add(it.get(i))
                    } catch (e: IndexOutOfBoundsException) {
                        e.printStackTrace()
                    }
                }
                authorAdapter.notifyDataSetChanged()

                listInspirations.clear()
                t?.let {

                    try {

                        for (i in 12..15)
                            listInspirations.add(it.get(i))
                    } catch (e: IndexOutOfBoundsException) {
                        e.printStackTrace()
                    }
                }
                inspirationAdapter.notifyDataSetChanged()


                listThemes.clear()
                t?.let {

                    try {

                        for (i in 16..19)
                            listThemes.add(it.get(i))
                    } catch (e: IndexOutOfBoundsException) {
                        e.printStackTrace()
                    }
                }
                themeAdapter.notifyDataSetChanged()


            }

        })

    }
}
