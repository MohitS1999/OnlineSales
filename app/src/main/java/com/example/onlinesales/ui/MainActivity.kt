package com.example.onlinesales.ui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.onlinesales.databinding.ActivityMainBinding
import com.example.onlinesales.model.History
import dagger.hilt.android.AndroidEntryPoint


private const val TAG = "MainActivity"
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: ")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.historyBtn.setOnClickListener {
            Log.d(TAG, "onCreate: history button click")

            val list = viewModel.getDataFromDB() as ArrayList
            binding.progressBar.visibility = View.VISIBLE
            binding.middleLL.visibility = View.GONE
            Handler().postDelayed(
                Runnable { binding.progressBar.visibility = View.GONE
                    binding.middleLL.visibility = View.VISIBLE},
                500
            )
            startActivity(Intent(this, HistoryActivty::class.java).apply {
                putExtra("historyList",list)

            })
        }
        binding.submitBtn.setOnClickListener {
            val stringList = binding.inputField.text.toString().split("\n")
            binding.inputField.setText("")
            binding.outputField.setText("")
            binding.progressBar.visibility = View.VISIBLE
            binding.middleLL.visibility = View.GONE

            val resFromApi = viewModel.callApi(stringList)
            Handler().postDelayed(
                Runnable { binding.progressBar.visibility = View.GONE
                    binding.middleLL.visibility = View.VISIBLE},
                500
            )
            Log.d(TAG, "onCreate:submit button $resFromApi")

            if (resFromApi.isEmpty()){
                binding.outputField.setText("Please Enter Correct Expression")
            }else{
                val history = mutableListOf<History>()
                for (i in stringList.indices){
                    history.add(History(0,stringList[i],resFromApi[i],java.time.LocalDate.now().toString()))
                }
                viewModel.saveData(history)
                val stringBuilder = StringBuilder()
                for(i in history.indices){
                    stringBuilder.append(history[i].input +" = > "+history[i].output+"\n")
                }
                binding.outputField.setText(stringBuilder)
            }
            //var resultString = emptyArray()
        }


        binding.clearBtn.setOnClickListener {
            binding.inputField.setText("")
            binding.outputField.setText("")
        }







        }
    }
