package com.example.mdi2_107_todoapp

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TodoViewModel: ViewModel() {
    // _tasks is private only this class can modify it
    // This is a Mutable list that holds all current task
    private val _tasks = mutableStateListOf<Task>()

    // tasks is public, the UI reads from the list but cannot modify it directly
    val tasks: List<Task> get() = _tasks

    // Counter used to generate a unique ID for each new task
    private var nextId = 1

    // Adds a new task to the list
    // Does nothing if the title is blank (empty or only spaces)
    fun addTask(title: String) {
        if(title.isNotBlank()) {
            // viewModelScope.launch start a new coroutine
            // everything inside this block runs WITHOUT blocking the main thread
//            viewModelScope.launch {
//                // withContext (Dispatchers.IO) switches to a background thread
//                withContext(Dispatchers.IO) {
//                    simulateSlowOperation()
//                }
//            }
            _tasks.add(Task(nextId++, title.trim()))
        }
    }

    // Removes a task from the list by its ID
    fun removeTask(taskId: Int) {
        _tasks.removeAll { it.id == taskId }
    }

    // Returns the number of tasks currently in the list
    // Used in Unit test to verify task were added correctly
    fun getTaskCount(): Int = _tasks.size

    // Returns true if a task with the given ID exists in the list
    // Used in Unit test to verify the correct task was added
    fun containsTask(title: String): Boolean = _tasks.any { it.title == title }

    private fun simulateSlowOperation() {
        Thread.sleep(3000) // pause for 3 seconds - simulates a slow database query
    }
}