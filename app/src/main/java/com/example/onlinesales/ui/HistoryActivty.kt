package com.example.onlinesales.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinesales.R
import com.example.onlinesales.adapter.HistoryAdapter
import com.example.onlinesales.databinding.ActivityHistoryActivtyBinding
import com.example.onlinesales.model.History

private const val TAG = "HistoryActivty"
class HistoryActivty : AppCompatActivity() {


    private lateinit var historyAdapter: HistoryAdapter
    private lateinit var binding: ActivityHistoryActivtyBinding
    private lateinit var historyRecyclerView: RecyclerView
    private lateinit var historyList:ArrayList<History>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryActivtyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        historyList = (intent?.extras?.getSerializable("historyList") as? ArrayList<History>)!!
        Log.d(TAG, "onCreate: $historyList")
        updateRecyclerView()
    }
    private fun updateRecyclerView(){
        Log.d(TAG, "updateRecyclerView: ")
        historyRecyclerView = binding.historyRV
        historyRecyclerView.setHasFixedSize(true)
        historyRecyclerView.addItemDecoration(
            DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL)
        )
        historyRecyclerView.setItemViewCacheSize(20)
        historyAdapter = HistoryAdapter(this,historyList)
        historyRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        historyRecyclerView.adapter = historyAdapter
    }
}