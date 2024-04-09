package com.innovative.porosh.todoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.innovative.porosh.todoapp.adapters.ToDoAdapter
import com.innovative.porosh.todoapp.databinding.FragmentToDoListBinding
import com.innovative.porosh.todoapp.dialogs.DeleteConfirmationDialog
import com.innovative.porosh.todoapp.entities.ToDoModel
import com.innovative.porosh.todoapp.utils.Constants
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
        val adapter = ToDoAdapter(::toDoAction)
        binding.toDoRv.layoutManager = LinearLayoutManager(activity)
        binding.toDoRv.adapter = adapter
        toDoViewModel.fetchAllToDos()
            .observe(viewLifecycleOwner,{toDoList ->
                adapter.submitList(toDoList)
            //Toast.makeText(activity, "${toDoList.size}",Toast.LENGTH_LONG).show()
        })
        binding.newToDoFat.setOnClickListener {
            findNavController().navigate(R.id.new_to_do_actions)
        }
        return binding.root
    }

    private fun toDoAction(toDoModel: ToDoModel, tag: String){
        when(tag){
            Constants.TODO_EDIT -> {
                toDoViewModel.updateToDo(toDoModel)
            }
            Constants.TODO_DELETE -> {
                DeleteConfirmationDialog {
                    toDoViewModel.deleteToDo(toDoModel)
                }.show(childFragmentManager,"delete")
            }
        }
    }

}