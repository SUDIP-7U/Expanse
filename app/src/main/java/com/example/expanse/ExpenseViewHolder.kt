package com.example.expanse

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExpenseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title: TextView = itemView.findViewById(R.id.title)
    val amount: TextView = itemView.findViewById(R.id.amount)
    val deleteButton: Button = itemView.findViewById(R.id.deleteBtn)
}
