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


        // when we click on the history button
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
        // when we click on the submit button
        binding.submitBtn.setOnClickListener {
            var stringList = binding.inputField.text.toString().split("\n")
            binding.inputField.setText("")
            binding.outputField.setText("")
            binding.progressBar.visibility = View.VISIBLE
            binding.middleLL.visibility = View.GONE

            // creating the new duplicate list for iterating 50-50
            var duplicateStringList = mutableListOf<String>()
            duplicateStringList.addAll(stringList)
            var resultFromAPI = mutableListOf<String>()
            Log.d(TAG, "onCreate: list :-      $duplicateStringList")
            while (duplicateStringList.isNotEmpty()){
                if (duplicateStringList.size <= 50){
                    Log.d(TAG, "onCreate: if stringlist is less than 50")
                    resultFromAPI.addAll(viewModel.callApi(duplicateStringList))
                    Handler().postDelayed(
                        Runnable { binding.progressBar.visibility = View.GONE
                            binding.middleLL.visibility = View.VISIBLE},
                        500
                    )
                    duplicateStringList.clear()
                }else{
                    Log.d(TAG, "onCreate: if stringlist is greater than 50")
                    val chunkList = duplicateStringList.take(50)
                    duplicateStringList = duplicateStringList.drop(50).toMutableList()
                    resultFromAPI.addAll(viewModel.callApi(chunkList))
                    Handler().postDelayed(
                        Runnable { binding.progressBar.visibility = View.GONE
                            binding.middleLL.visibility = View.VISIBLE},
                        500
                    )

                }
            }
            //calling the math api

            Log.d(TAG, "onCreate:submit button $resultFromAPI")

            // if the list is empty
            if (resultFromAPI.isEmpty()){
                binding.outputField.setText("Please Enter Correct Expression")
            }else{
                // if list is not empty
                val history = mutableListOf<History>()
                for (i in stringList.indices){
                    history.add(History(0,stringList[i],resultFromAPI[i],java.time.LocalDate.now().toString()))
                }

                // save the data into db
                viewModel.saveData(history)
                val stringBuilder = StringBuilder()
                for(i in history.indices){
                    stringBuilder.append(history[i].input +" = > "+history[i].output+"\n")
                }
                binding.outputField.setText(stringBuilder)
            }
            //var resultString = emptyArray()
        }

        //when we click on the clear button
        binding.clearBtn.setOnClickListener {
            binding.inputField.setText("")
            binding.outputField.setText("")
        }







        }


}
