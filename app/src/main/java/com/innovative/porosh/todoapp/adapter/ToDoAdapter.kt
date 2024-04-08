package com.innovative.porosh.todoapp.adapter

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.innovative.porosh.todoapp.R
import com.innovative.porosh.todoapp.databinding.TodoItemRowBinding
import com.innovative.porosh.todoapp.entities.ToDoModel
import com.innovative.porosh.todoapp.utils.Constants
import com.innovative.porosh.todoapp.utils.Functions

class ToDoAdapter {


    class ToDoViewHolder(private val binding: TodoItemRowBinding): ViewHolder(binding.root){
        fun bind(toDoModel: ToDoModel){
            binding.rowTodoNameTv.text = toDoModel.name
            binding.rowDateTimeTv.text = "${Functions.getFormattedDateTime(toDoModel.date, "dd/MM/yyyy")} ${Functions.getFormattedDateTime(toDoModel.time, "hh:MM a")}"
            binding.rowTodoCompletedCb.isChecked = toDoModel.isCompleted

            val iconId = when(toDoModel.priority){
                Constants.PRIORITY_LOW -> R.drawable.ic_blue_star_24
                Constants.PRIORITY_NORMAL -> R.drawable.ic_red_star_24
                else -> R.drawable.ic_red_star_24
            }
            binding.rowTodoPriorityImg.setImageResource(iconId)

        }
    }

    /*
    * This class is used to redraw only the change or newly added item
    * instead of redraw the whole recycler view
    * */
    class ToDoDiffCallback: DiffUtil.ItemCallback<ToDoModel>(){
        override fun areItemsTheSame(oldItem: ToDoModel, newItem: ToDoModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ToDoModel, newItem: ToDoModel): Boolean {
            return oldItem == newItem
        }

    }

}