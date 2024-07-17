package com.example.androidmemoryusage.app

import android.util.Log

const val TAG = "logCurrentMemoryUsage"

fun logCurrentMemoryUsage(src: String) {
    val maxMemoryInMb = Runtime.getRuntime()
        .maxMemory() / 1024 / 1024 // maxMemory() is the maximum heap size (totalMemory() <= maxMemory())
    val totalMemoryInMb = Runtime.getRuntime()
        .totalMemory() / 1024 / 1024 // totalMemory() is the current heap size (totalMemory() = freeMemory() + usedMemory())
    val freeMemoryInMb = Runtime.getRuntime()
        .freeMemory() / 1024 / 1024 // freeMemory() is the amount of memory available in the heap (totalMemory() - usedMemory())
    val usedMemoryInMb =
        totalMemoryInMb - freeMemoryInMb // usedMemory = totalMemory - freeMemory (totalMemory is the current heap size)

    Log.d(TAG, "********** Memory Usage **********")
    Log.d(TAG, "Start Stack Trace: $src")

    Log.d(TAG, "Max Memory: $maxMemoryInMb MB")
    Log.d(TAG, "Total Memory: $totalMemoryInMb MB")
    Log.d(TAG, "Free Memory: $freeMemoryInMb MB")
    Log.d(TAG, "Used Memory: $usedMemoryInMb MB")

    Log.d(TAG, "End Stack Trace: $src")
    Log.d(TAG, "**********************************")
}