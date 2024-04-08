package com.innovative.porosh.todoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.innovative.porosh.todoapp.databinding.FragmentToDoListBinding
import com.innovative.porosh.todoapp.db.ToDoDatabase
import com.innovative.porosh.todoapp.viewModels.ToDoViewModel

class ToDoListFragment : Fragment() {

    private lateinit var binding: FragmentToDoListBinding
    private val toDoViewModel: ToDoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentToDoListBinding.inflate(inflater,container,false)
        toDoViewModel.fetchAllToDos()
            .observe(viewLifecycleOwner,{toDoList ->
            Toast.makeText(activity, "${toDoList.size}",Toast.LENGTH_LONG).show()
        })
        binding.newToDoFat.setOnClickListener {
            findNavController().navigate(R.id.new_to_do_actions)
        }
        return binding.root
    }

}