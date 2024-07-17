package com.example.androidmemoryusage.app

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var idList = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        logCurrentMemoryUsage("MainActivity.onCreate()")
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        logCurrentMemoryUsage("MainActivity.onCreate() after setContentView()")

        Thread {
            Thread.sleep(1000)
            logCurrentMemoryUsage("MainActivity.onCreate() after 1 second delay")
        }.start()
    }

    fun executeHeavyTask(view: View) {
        for (i in 0..1000000) {
            idList.add(i)
        }
        logCurrentMemoryUsage("MainActivity.executeHeavyTask()")
    }
}