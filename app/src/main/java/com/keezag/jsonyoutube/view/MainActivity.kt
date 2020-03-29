package com.keezag.jsonyoutube.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.keezag.jsonyoutube.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //recycleView
        recyclerView_main.layoutManager = LinearLayoutManager(this)
       // recyclerView_main.adapter = ??


    }
}
