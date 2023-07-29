package com.example.onlinesales

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.room.Room
import com.example.onlinesales.databinding.ActivityMainBinding
import com.example.onlinesales.db.HistoryDB
import com.example.onlinesales.model.History
import com.example.onlinesales.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

private const val TAG = "MainActivity"
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: ")
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val list = mutableListOf<History>()
        list.add(History(0,"mohit","mohit","15march2022"))
        list.add(History(0,"sahil","lofi","18april2022"))
        list.add(History(0,"saifi","coffee","15march2022"))
        list.add(History(0,"kulu","mohit","15march2022"))
        //list.add(History(1,"yugal","mohit","15march2022"))

        viewModel.saveData(list)
    }
}