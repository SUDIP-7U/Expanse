package com.example.expanse

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ExpenseViewModel(application: Application) : AndroidViewModel(application) {
    private val repo: ExpenseRepository
    val allExpenses: LiveData<List<Expense>>

    init {
        val dao = ExpenseDatabase.getDatabase(application).expenseDao()
        repo = ExpenseRepository(dao)
        allExpenses = repo.allExpenses
    }

    fun insert(expense: Expense) = viewModelScope.launch {
        repo.insert(expense)
    }

    fun delete(expense: Expense) = viewModelScope.launch {
        repo.delete(expense)
    }
}
