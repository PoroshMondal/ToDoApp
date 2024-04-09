package com.innovative.porosh.todoapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.innovative.porosh.todoapp.R
import com.innovative.porosh.todoapp.databinding.TodoItemRowBinding
import com.innovative.porosh.todoapp.entities.ToDoModel
import com.innovative.porosh.todoapp.utils.Constants
import com.innovative.porosh.todoapp.utils.Functions

class ToDoAdapter(private val actionCallback: (ToDoModel, String) -> Unit): ListAdapter<ToDoModel, ToDoAdapter.ToDoViewHolder>(ToDoDiffCallback()) {

    class ToDoViewHolder(
        private val binding: TodoItemRowBinding,
        val actionCallback: (ToDoModel, String) -> Unit
    ): ViewHolder(binding.root){
        fun bind(toDoModel: ToDoModel){
            binding.todo = toDoModel
            //binding.rowTodoNameTv.text = toDoModel.name
            //binding.rowDateTimeTv.text = "${Functions.getFormattedDateTime(toDoModel.date, "dd/MM/yyyy")} ${Functions.getFormattedDateTime(toDoModel.time, "hh:MM a")}"
            //binding.rowTodoCompletedCb.isChecked = toDoModel.isCompleted

            /*val iconId = when(toDoModel.priority){
                Constants.PRIORITY_LOW -> R.drawable.ic_blue_star_24
                Constants.PRIORITY_NORMAL -> R.drawable.ic_green_star_24
                else -> R.drawable.ic_red_star_24
            }*/
            //binding.rowTodoPriorityImg.setImageResource(iconId)

            binding.rowTodoCompletedCb.setOnClickListener {
                actionCallback(toDoModel, Constants.TODO_EDIT)
            }

            binding.rowMenuIcon.setOnClickListener {
                val popupMenu = PopupMenu(it.context, it)
                val inflater = popupMenu.menuInflater
                inflater.inflate(R.menu.todo_row_menu,popupMenu.menu)
                popupMenu.show()

                popupMenu.setOnMenuItemClickListener { item ->
                    when(item.itemId){
                        R.id.item_delete -> {
                            actionCallback(toDoModel,Constants.TODO_DELETE)
                            true
                        }
                        else -> {
                            false
                        }
                    }
                }
            }

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val binding = TodoItemRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ToDoViewHolder(binding,actionCallback)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val todoModel = getItem(position)
        holder.bind(todoModel)
     }

}