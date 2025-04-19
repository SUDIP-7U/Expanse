package com.example.expanse

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ExpenseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etTitle = findViewById<EditText>(R.id.etTitle)
        val etAmount = findViewById<EditText>(R.id.etAmount)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        viewModel = ViewModelProvider(this)[ExpenseViewModel::class.java]

        viewModel.allExpenses.observe(this) { list ->
            recyclerView.adapter = ExpenseAdapter(list) { expense ->
                viewModel.delete(expense)
            }
            recyclerView.layoutManager = LinearLayoutManager(this)
        }

        btnAdd.setOnClickListener {
            val title = etTitle.text.toString()
            val amount = etAmount.text.toString().toDoubleOrNull()
            if (title.isNotBlank() && amount != null) {
                val expense = Expense(title = title, amount = amount)
                viewModel.insert(expense)
                etTitle.text.clear()
                etAmount.text.clear()
            }
        }
    }
}
