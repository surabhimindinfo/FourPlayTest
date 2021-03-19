package com.example.fourplaytest.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
  import com.example.fourplaytest.models.Article
import com.example.fourplaytest.R
import com.example.fourplaytest.activities.MapActivity


class InspirationAdapter(private val context: Context, private var list: MutableList<Article>) : RecyclerView.Adapter<InspirationAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.heading_row,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val article = list.get(position)
        holder.text?.text = article.getTitle()

        if (article.getUrlToImage() == null)
            article.setUrlToImage("https://colorlib.com/wp/wp-content/uploads/sites/2/Green_themes.png")

        if (article.getTitle() == null)
            article.setTitle("Unknown")

        holder.view.requestLayout()
        holder.view.getLayoutParams()!!.width = 500
        holder.view.getLayoutParams()!!.height = 750
        Glide.with(context).load(article.getUrlToImage()).into(holder.image!!)
        holder.view.setOnClickListener(View.OnClickListener {
            context.startActivity( Intent(context, MapActivity::class.java))
        })
    }

    class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view){

        var image: ImageView? = null
        var text: TextView? = null

        init {
            image = view.findViewById(R.id.image)
            text = view.findViewById(R.id.textView)
        }

    }

}