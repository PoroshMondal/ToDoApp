package com.innovative.porosh.todoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.innovative.porosh.todoapp.databinding.FragmentToDoListBinding

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
        binding.newToDoFat.setOnClickListener {
            findNavController().navigate(R.id.new_to_do_actions)
        }
        return binding.root
    }

}