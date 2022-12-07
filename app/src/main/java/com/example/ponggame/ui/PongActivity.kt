package com.example.ponggame.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.example.ponggame.R
import com.example.ponggame.databinding.ActivityPongBinding
import com.example.ponggame.utils.GameView

class PongActivity : AppCompatActivity() {

//1
    private lateinit var binding: ActivityMainBinding


  


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPongBinding.inflate(layoutInflater)
        setContentView(GameView(this))

//        supportFragmentManager.commit {
//            add(R.id.frame_content, GameFragment())
//        }

    }

//    fun updateText(str: String) {
//        runOnUiThread(Runnable {
//            binding.textView.text = str
//        })
//    }

}