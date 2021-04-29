package com.example.saveup.ui.form

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.saveup.R

/**
 * A placeholder fragment containing a simple view.
 */
class ExpenseFragment : Fragment() {

    private lateinit var pageViewModel: PageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProvider(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_expense, container, false)

        val save_expense: View = root.findViewById(R.id.save_button_expense)
        save_expense.setOnClickListener{
            val expense_text = root.findViewById<EditText>(R.id.euro_expense).text.toString()
            // val expense = Integer.parseInt(expense_text)
            val date = root.findViewById<EditText>(R.id.date_input_field_expense).text.toString()
            val account = root.findViewById<EditText>(R.id.account_input_field_expense).text.toString()
            val category = root.findViewById<EditText>(R.id.category_input_field_expense).text.toString()
            val description = root.findViewById<EditText>(R.id.description_input_field_expense).text.toString()

            // root.findViewById<TextView>(R.id.test_text_view).text = account
        }

        return root
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): ExpenseFragment {
            return ExpenseFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}