package com.example.todoapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.Fragment

class TodoFragment : Fragment() {
    private var mTodo: Todo? = null
    private lateinit var mEditTextTitle: EditText
    private lateinit var mButtonDate: Button
    private lateinit var mCheckBoxIsComplete: CheckBox
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mTodo = Todo()
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_todo, container, false)
        mEditTextTitle = view.findViewById<View>(R.id.todo_title) as EditText
        mEditTextTitle.setText(mTodo!!.title)
        mEditTextTitle.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // This line is intentionally left blank
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                mTodo!!.title = s.toString()
            }

            override fun afterTextChanged(s: Editable) {
                // This line is intentionally left blank
            }
        })
        mButtonDate = view.findViewById<View>(R.id.todo_date) as Button
        mButtonDate.setText(mTodo!!.date.toString())
        mButtonDate!!.isEnabled = false
        mCheckBoxIsComplete = view.findViewById<View>(R.id.todo_complete) as CheckBox
        mCheckBoxIsComplete!!.setOnCheckedChangeListener { buttonView, isChecked ->
            Log.d("DEBUG **** TodoFragment", "called onCheckedChanged")
            mTodo!!.isComplete = isChecked
        }
        return view
    }

    companion object {
        private const val ARG_TODO_ID = "todo_id"
    }
}