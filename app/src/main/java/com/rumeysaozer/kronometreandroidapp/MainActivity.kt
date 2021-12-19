package com.rumeysaozer.kronometreandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import com.rumeysaozer.kronometreandroidapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var durdur: Long = 0
        binding.start.setOnClickListener {
            binding.kronometre.base = SystemClock.elapsedRealtime()+durdur
            binding.kronometre.start()
            binding.start.visibility = View.GONE
            binding.pause.visibility = View.VISIBLE
        }
        binding.pause.setOnClickListener {
            durdur = binding.kronometre.base-SystemClock.elapsedRealtime()
            binding.kronometre.stop()
            binding.start2.visibility = View.VISIBLE
            binding.reset.visibility = View.VISIBLE
            binding.pause.visibility = View.GONE
        }
        binding.reset.setOnClickListener {
            binding.kronometre.base = SystemClock.elapsedRealtime()
            binding.kronometre.stop()
            durdur = 0
            binding.start2.visibility = View.GONE
            binding.reset.visibility = View.GONE
            binding.pause.visibility = View.GONE
            binding.start.visibility = View.VISIBLE
        }
        binding.start2.setOnClickListener {
            binding.kronometre.base = SystemClock.elapsedRealtime()+durdur
            binding.kronometre.start()
            binding.start2.visibility = View.GONE
            binding.reset.visibility = View.GONE
            binding.pause.visibility = View.VISIBLE
            binding.start.visibility = View.GONE
        }
    }


}