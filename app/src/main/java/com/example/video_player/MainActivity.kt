package com.example.video_player


import android.net.Uri
import android.net.Uri.*
import android.widget.MediaController
import android.widget.VideoView

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.video_player.databinding.ActivityMainBinding
import java.util.logging.Level
import java.util.logging.Level.parse

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val videoView = findViewById<VideoView>(binding.testView.id) //R.id.testView

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        val uri = Uri.parse(
            "android.resource://" +packageName + "/raw/mlp_test"
        )

        videoView.setMediaController(mediaController)
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()

    }
}