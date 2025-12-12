package com.example.kindnessjar.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.time.LocalDate

class MainViewModel : ViewModel() {

    // Fake temporary challenge for UI-only stage
    private val _todayChallenge = MutableStateFlow("Feed a street dog today")
    val todayChallenge: StateFlow<String> = _todayChallenge

    // Fake streak (temporary)
    private val _streak = MutableStateFlow(3)
    val streak: StateFlow<Int> = _streak

    // Fake weekly progress boxes (temporary)
    private val _weeklyCompleted = MutableStateFlow(3)
    val weeklyCompleted: StateFlow<Int> = _weeklyCompleted

    // Fake history list (temporary)
    private val _history = MutableStateFlow(
        listOf(
            HistoryItem("Helped Mom Cook", "22-01-2024"),
            HistoryItem("Donated Old Clothes", "23-01-2024"),
            HistoryItem("Fed a Street Dog", "24-01-2024")
        )
    )
    val history: StateFlow<List<HistoryItem>> = _history

    // Later this will save to Room DB
    @RequiresApi(Build.VERSION_CODES.O)
    fun markTodayCompleted() {
        val today = LocalDate.now().toString()

        val newItem = HistoryItem(_todayChallenge.value, today)
        val current = _history.value.toMutableList()

        current.add(0, newItem) // add new entry at top

        _history.value = current
        _streak.value += 1 // simple fake logic
        _weeklyCompleted.value += 1
    }
}

data class HistoryItem(
    val title: String,
    val date: String
)
