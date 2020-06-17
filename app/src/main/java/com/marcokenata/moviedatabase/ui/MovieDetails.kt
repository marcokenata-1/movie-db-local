package com.marcokenata.moviedatabase.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.marcokenata.moviedatabase.R

class MovieDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

         val getTitle = intent.extras?.get("movieTitle")
        setSupportActionBar(findViewById(R.id.my_toolbar_details))

        supportActionBar?.title = getTitle.toString()
    }
}