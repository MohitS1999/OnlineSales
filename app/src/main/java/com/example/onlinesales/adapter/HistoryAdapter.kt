package com.example.onlinesales.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinesales.databinding.HistorydataBinding
import com.example.onlinesales.model.History

private const val TAG = "HistoryAdapter"
class HistoryAdapter(
    private val context: Context,
    private val historyList:ArrayList<History>
) :RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HistoryAdapter.HistoryViewHolder {
        return HistoryViewHolder(HistorydataBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun onBindViewHolder(holder: HistoryAdapter.HistoryViewHolder, position: Int) {
        val data = historyList[position]
        holder.inputData.text = data.input
        holder.outputData.text = "=>  "+data.output
        holder.date.text = data.date
    }

    override fun getItemCount(): Int {
        return historyList.size
    }

    class HistoryViewHolder(binding:HistorydataBinding) : RecyclerView.ViewHolder(binding.root){
        val inputData = binding.input
        val outputData = binding.output
        val date = binding.date
    }

}