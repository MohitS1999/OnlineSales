package com.example.onlinesales.ui

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.onlinesales.databinding.ActivityMainBinding
import com.example.onlinesales.model.History
import dagger.hilt.android.AndroidEntryPoint



private const val TAG = "MainActivity"
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: ")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val list = arrayListOf<History>()
        list.add(History(0, "mohit", "mohit", "15march2022"))
        list.add(History(0, "sahil", "lofi", "18april2022"))
        list.add(History(0, "saifi", "coffee", "15march2022"))
        list.add(History(0, "kulu", "mohit", "15march2022"))

        viewModel.saveData(list)

        binding.historyBtn.setOnClickListener {
            Log.d(TAG, "onCreate: history button click")

            startActivity(Intent(this, HistoryActivty::class.java).apply {
                putExtra("historyList",list)

            })
        }
        binding.submitBtn.setOnClickListener {

        }









        }
    }
