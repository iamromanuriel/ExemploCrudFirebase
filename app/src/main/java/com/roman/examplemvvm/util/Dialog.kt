package com.roman.examplemvvm.util

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.roman.examplemvvm.data.Repositorydatabase

class Dialog : DialogFragment() {
    lateinit var idu : String

    fun DialogInit(idu : String){
        this.idu = idu
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction

            val builder = AlertDialog.Builder(it)
            builder.setMessage("¿Quiere eliminar?")
                .setPositiveButton("Ok",
                    DialogInterface.OnClickListener { dialog, id ->
                        //Toast.makeText(context, idu, Toast.LENGTH_SHORT).show()
                        deleteuser(idu)
                    })
                .setNegativeButton("cancel",
                    DialogInterface.OnClickListener { dialog, id ->
                        // User cancelled the dialog
                    })
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    fun deleteuser(id : String){
        var repositorydatabase = Repositorydatabase()
        repositorydatabase.deleteuser(id)
    }
}