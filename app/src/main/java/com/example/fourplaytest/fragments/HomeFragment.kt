package com.example.fourplaytest.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fourplaytest.R
import com.example.fourplaytest.adapters.*
import com.example.fourplaytest.models.Article
import com.example.fourplaytest.viewmodels.DataViewModel
import com.example.fourplaytest.viewmodelsfactories.DataViewModelFactory
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

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
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container,
            false)
        view.content_layout.visibility = View.GONE
        view.shimmerLayout.startShimmer()
        view.recycler_main.layoutManager =
            LinearLayoutManager(context , LinearLayoutManager.HORIZONTAL, false)
        view.recycler_heading.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        view.recycler_author.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        view.recycler_inspirations.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        view.recycler_themes.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)


        listNews = mutableListOf<Article>()
        listHeading = mutableListOf<Article>()
        listAuthor = mutableListOf<Article>()
        listInspirations = mutableListOf<Article>()
        listThemes = mutableListOf<Article>()


        adapter = SliderAdapter(
            requireContext(),
            listNews
        )

        headingadapter = NewsHeading(
            requireContext(),
            listHeading
        )
        authorAdapter = AuthorAdapter(
            requireContext(),
            listAuthor
        )
        inspirationAdapter = InspirationAdapter(
            requireContext(),
            listInspirations
        )
        themeAdapter = ThemeAdapter(
            requireContext(),
            listThemes
        )




        view.recycler_main.adapter = adapter
        view.recycler_heading.adapter = headingadapter
        view.recycler_author.adapter = authorAdapter
        view.recycler_inspirations.adapter = inspirationAdapter
        view.recycler_themes.adapter = themeAdapter

        view.setNestedScrollingEnabled(  false)

        val dataViewModel =
            ViewModelProviders.of(this, DataViewModelFactory(requireContext())).get(DataViewModel::class.java)
        dataViewModel.getData().observe(this, object : Observer<ArrayList<Article>> {
            override fun onChanged(t: ArrayList<Article>?) {

                view.shimmerLayout.stopShimmer()
                view.shimmerLayout.visibility = View.GONE
                view.content_layout.visibility = View.VISIBLE

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
        return view
    }

    companion object {
        fun newInstance(): HomeFragment = HomeFragment()
    }

}