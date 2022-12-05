package com.example.ponggame.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.example.ponggame.R
import com.example.ponggame.databinding.ActivityMainBinding

class PongActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.commit {
            add(R.id.frame_content, GameFragment())
        }

    }

    fun updateText(str: String) {
        runOnUiThread(Runnable {
            binding.textView.text = str
        })
    }

}