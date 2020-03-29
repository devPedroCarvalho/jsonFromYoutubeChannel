package com.keezag.jsonyoutube

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.keezag.jsonyoutube.view.HomeFeed
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_list.view.*

class MainAdapter(val homeFeed: HomeFeed) : RecyclerView.Adapter<CustomViewHolder>() {

    //val videoTitles = listOf("Primeiro titulo","Segundo titulo", "Terceiro titulo","quarto")

    override fun getItemCount(): Int {
     return homeFeed.videos.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        // create a new view
        val textView = LayoutInflater.from(parent.context).inflate(R.layout.layout_list, parent, false)
        return CustomViewHolder(textView)

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        //val videoTitles = videoTitles[position]
        val video = homeFeed.videos[position]
        holder.view.txt_titleVideo.text = video.name
        val profileImageView = holder.view.imageView
        Picasso.get()
            .load(video.imageUrl)
            .into(profileImageView)




    }

}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view){

}