package com.marcokenata.moviedatabase.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.marcokenata.moviedatabase.R
import dagger.android.AndroidInjection

class MovieFavoriteHost : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_favorite)

        setSupportActionBar(findViewById(R.id.my_toolbar_fav))

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        supportActionBar?.title = "Favorites"
    }


}