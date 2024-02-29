package com.example.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.todoapp.ui.TodoUIScreen
import com.example.todoapp.ui.theme.TodoTheme

class TodoActivity : ComponentActivity() {

    private lateinit var todo:Todo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState != null) {
            if(savedInstanceState.containsKey("todo")) {
                todo = savedInstanceState.getSerializable("todo", Todo::class.java)!!
            }
        }
        else todo = Todo()

        setContent {
            TodoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TodoUIScreen(todo, Modifier)
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable("todo", todo )
    }
}
