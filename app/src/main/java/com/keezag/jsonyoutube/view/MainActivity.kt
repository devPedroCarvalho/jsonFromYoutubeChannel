package com.keezag.jsonyoutube.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import com.keezag.jsonyoutube.MainAdapter
import com.keezag.jsonyoutube.R
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //recycleView
        recyclerView_main.layoutManager = LinearLayoutManager(this)
       // recyclerView_main.adapter = MainAdapter()
        fetchJson()
    }

    private fun fetchJson() {
        val url = "https://api.letsbuildthatapp.com/youtube/home_feed"

        var request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue( object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call, response: Response) {
               val body = response.body?.string()
                print(body)

                val gson = GsonBuilder().create()
                val homeFeed = gson.fromJson(body,HomeFeed::class.java)

                runOnUiThread{
                    recyclerView_main.adapter = MainAdapter(homeFeed)

                }


            }

        })

    }

}

class HomeFeed( val videos: List<Video>)

class Video ( val id: Int, val name: String, val link: String, val imageUrl: String, val numberOfViews: Int, val channel: Channel)

class Channel(val name: String, val profileImageUrl: String)

