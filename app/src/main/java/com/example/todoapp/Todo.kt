package com.example.todoapp

import java.util.Date
import java.util.UUID

data class Todo (
    var id: UUID? = null,
    var title: String? = null,
    var detail: String? = null,
    var date: Date = Date(),
    var isComplete:Boolean = false,
) : java.io.Serializable{

    init {
        id = UUID.randomUUID()
        date = Date()
    }

}

