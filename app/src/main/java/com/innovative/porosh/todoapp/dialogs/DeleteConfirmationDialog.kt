package com.innovative.porosh.todoapp.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.innovative.porosh.todoapp.R

class DeleteConfirmationDialog(val callback: () -> Unit): DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("Delete")
        builder.setIcon(R.drawable.ic_delete_24)
        builder.setMessage("Are you sure to delete this item?")
        builder.setPositiveButton("Yes") { dialog, which ->
            callback()
        }
        builder.setNegativeButton("Cancel",null)

        return builder.create()
    }

}