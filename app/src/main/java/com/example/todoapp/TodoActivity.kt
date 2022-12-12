package com.example.todoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class TodoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        val fm = supportFragmentManager
        val fragment = fm.findFragmentById(R.id.fragment_container)
        if (fragment == null) {
            val todoFragment = TodoFragment()
            fm.beginTransaction()
                    .add(R.id.fragment_container, todoFragment)
                    .commit()
        }
    }
}