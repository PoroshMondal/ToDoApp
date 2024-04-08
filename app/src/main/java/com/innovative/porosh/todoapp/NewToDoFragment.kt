package com.innovative.porosh.todoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import com.innovative.porosh.todoapp.databinding.FragmentNewToDoBinding
import com.innovative.porosh.todoapp.db.ToDoDatabase
import com.innovative.porosh.todoapp.dialogs.DatePickerDialogFragment
import com.innovative.porosh.todoapp.dialogs.TimePickerDialogFragment
import com.innovative.porosh.todoapp.entities.ToDoModel
import com.innovative.porosh.todoapp.utils.Constants
import com.innovative.porosh.todoapp.utils.Functions

class NewToDoFragment : Fragment() {

    private lateinit var binding: FragmentNewToDoBinding
    private var priority = Constants.PRIORITY_NORMAL
    private var dateInMillis = System.currentTimeMillis()
    private var timeInMillis = System.currentTimeMillis()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewToDoBinding.inflate(inflater,container,false)
        binding.priorityRg.setOnCheckedChangeListener { radioGroup, radioBtnId ->
            val rd = radioGroup.findViewById<RadioButton>(radioBtnId)
            priority = rd.text.toString().trim()
            Toast.makeText(activity,priority,Toast.LENGTH_LONG).show()
        }

        binding.dateBtn.setOnClickListener {
            DatePickerDialogFragment {timeStamp ->
                dateInMillis = timeStamp
                binding.dateBtn.text = Functions.getFormattedDateTime(dateInMillis,"dd-MM-yyyy")
            }.show(childFragmentManager,"date_picker")
        }

        binding.timeBtn.setOnClickListener {
            TimePickerDialogFragment {timeStamp ->
                timeInMillis = timeStamp
                binding.timeBtn.text = Functions.getFormattedDateTime(timeInMillis,"hh:mm a")
            }.show(childFragmentManager,"time_picker")
        }

        binding.saveBtn.setOnClickListener {
            val toDoName = binding.toDoInputEt.text.toString().trim()
            if (toDoName.isEmpty()){
                binding.toDoInputEt.error = "Please provide a valid ToDo name"
                return@setOnClickListener
            }

            val toDo = ToDoModel(name = toDoName, priority = priority, date = dateInMillis, time = timeInMillis)

            ToDoDatabase.getDB(requireActivity()).getToDoDao().addToDo(toDo)

        }

        return binding.root
    }

}