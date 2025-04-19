package com.example.expanse

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Expense(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val title: String,

    val amount: Double
)

//  id("com.google.devtools.ksp") version "2.0.21-1.0.27" apply false
//  id("com.google.devtools.ksp")

//  implementation(libs.androidx.room.ktx)
//    ksp(libs.androidx.room.compiler)

// // Lifecycle ViewModel coroutine support
//    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.7")
//    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.7")

