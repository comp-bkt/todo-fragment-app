package com.example.todoapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todoapp.R
import com.example.todoapp.Todo

@Composable
fun TodoUIScreen (todo: Todo, modifier: Modifier){
    val input: MutableState<String> = rememberSaveable { mutableStateOf("")}
    val isChecked = rememberSaveable { mutableStateOf(false) }

    /*currently saved instance state used to save a Bundle and then passed to
    composable on Orientation change - consider chaging to watching the address
    space of the Todo Object to force the recomposition*/

    isChecked.value = todo.isComplete
    input.value = todo.detail?:""

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Top
    ){
        Text(text = stringResource(id = R.string.todo_title_label),
            fontWeight = FontWeight.Bold
        )
        TextField(value = input.value,
            onValueChange = { it ->
                input.value = it
                todo.detail = it
            }
        )
        Text(text = stringResource(id = R.string.todo_detail_label),
            fontWeight = FontWeight.Bold
        )
        Button(
            modifier = Modifier.fillMaxWidth(),
            shape = RectangleShape,
            onClick = {}
        ){
            Text(todo.date.toString())
        }
        Spacer(Modifier.size(6.dp))
        Checkbox(
            checked =   isChecked.value,
            onCheckedChange = {
                isChecked.value = it
                todo.isComplete = it
            }
        )
    }
}

@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun TodoUIPreview(){
    TodoUIScreen(
        Todo(),
        Modifier
    )
}