package com.example.prueba2ejercicio1

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class ClassItem(val name: String, val day: String, val time: String)

class ScheduleViewModel : ViewModel() {
    private val _classes = MutableStateFlow<List<ClassItem>>(emptyList())
    val classes: StateFlow<List<ClassItem>> = _classes

    fun addClass(classItem: ClassItem) {
        _classes.value = _classes.value + classItem
    }

    fun getClassesForDay(day: String): List<ClassItem> {
        return _classes.value.filter { it.day == day }
    }
}
