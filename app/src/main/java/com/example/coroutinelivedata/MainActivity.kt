package com.example.coroutinelivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.coroutinelivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Obtain ViewModel
    private val viewmodel: LiveDataViewModel by viewModels { LiveDataVMFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        // Obtain binding object using the Data Binding library
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(
                this, R.layout.activity_main
        )

        // Set the LifecycleOwner to be able to observe LiveData objects
        binding.lifecycleOwner = this

        // Bind ViewModel
        binding.viewmodel = viewmodel
    }
}