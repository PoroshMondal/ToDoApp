package com.innovative.porosh.todoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.innovative.porosh.todoapp.databinding.FragmentToDoListBinding
import com.innovative.porosh.todoapp.db.ToDoDatabase

class ToDoListFragment : Fragment() {

    private lateinit var binding: FragmentToDoListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentToDoListBinding.inflate(inflater,container,false)
        ToDoDatabase.getDB(requireActivity())
            .getToDoDao()
            .getAllToDos()
            .observe(viewLifecycleOwner,{toDoList ->
            Toast.makeText(activity, "${toDoList.size}",Toast.LENGTH_LONG).show()
        })
        binding.newToDoFat.setOnClickListener {
            findNavController().navigate(R.id.new_to_do_actions)
        }
        return binding.root
    }

}