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

                "Description Ascending" -> {
                    sortListBy = "Description Ascending"
                    listAdapter.items.sort()
                    listAdapter.notifyDataSetChanged()
                }
                "Description Descending" -> {
                    sortListBy = "Description Descending"
                    listAdapter.items.sort()
                    listAdapter.items.reverse()
                    listAdapter.notifyDataSetChanged()
                }
                "Amount Ascending" -> {
                    sortListBy = "Amount Ascending"
                    listAdapter.items.sort()
                    listAdapter.notifyDataSetChanged()
                }
                "Amount Descending" -> {
                    sortListBy = "Amount Descending"
                    listAdapter.items.sort()
                    listAdapter.items.reverse()
                    listAdapter.notifyDataSetChanged()
                }
                "Описание По возрастанию" -> {
                    sortListBy = "Description Ascending"
                    listAdapter.items.sort()
                    listAdapter.notifyDataSetChanged()
                }
                "Описание По убыванию" -> {
                    sortListBy = "Description Descending"
                    listAdapter.items.sort()
                    listAdapter.items.reverse()
                    listAdapter.notifyDataSetChanged()
                }
                "Сумма по возрастанию" -> {
                    sortListBy = "Amount Ascending"
                    listAdapter.items.sort()
                    listAdapter.notifyDataSetChanged()
                }
                "Сумма по убыванию" -> {
                    sortListBy = "Amount Descending"
                    listAdapter.items.sort()
                    listAdapter.items.reverse()
                    listAdapter.notifyDataSetChanged()
                }
                "說明 升序" -> {
                    sortListBy = "Description Ascending"
                    listAdapter.items.sort()
                    listAdapter.notifyDataSetChanged()
                }
                "描述 降序" -> {
                    sortListBy = "Description Descending"
                    listAdapter.items.sort()
                    listAdapter.items.reverse()
                    listAdapter.notifyDataSetChanged()
                }
                "金額遞增" -> {
                    sortListBy = "Amount Ascending"
                    listAdapter.items.sort()
                    listAdapter.notifyDataSetChanged()
                }
                "金額遞減" -> {
                    sortListBy = "Amount Descending"
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
