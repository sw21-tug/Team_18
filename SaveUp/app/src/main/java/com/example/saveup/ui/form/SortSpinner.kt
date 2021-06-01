package com.example.saveup.ui.form

import ListAdapter
import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.AdapterView
import java.lang.Exception
import com.example.saveup.ProfileActivity.Companion.sortListBy

class SortSpinner(private val listAdapter: ListAdapter, val context: Context) : Activity(), AdapterView.OnItemSelectedListener {

    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {

        try {
            when (parent.getItemAtPosition(pos)) {
                "description_ascending" -> {
                    sortListBy = "description_ascending"
                    listAdapter.items.sort()
                    listAdapter.notifyDataSetChanged()
                }
                "description_descending" -> {
                    sortListBy = "description_descending"
                    listAdapter.items.sort()
                    listAdapter.items.reverse()
                    listAdapter.notifyDataSetChanged()
                }
                "amount_ascending" -> {
                    sortListBy = "amount_ascending"
                    listAdapter.items.sort()
                    listAdapter.notifyDataSetChanged()
                }
                "amount_descending" -> {
                    sortListBy = "amount_descending"
                    listAdapter.items.sort()
                    listAdapter.items.reverse()
                    listAdapter.notifyDataSetChanged()
                }
            }
        }
        catch (e: Exception)
        {
            println(e)
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        // Another interface callback
    }
}
