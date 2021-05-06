package com.example.saveup.ui.form

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.saveup.FormActivity
import com.example.saveup.R
import java.lang.reflect.Method
import java.nio.charset.Charset
import java.text.SimpleDateFormat
import java.util.*

/**
 * A placeholder fragment containing a simple view.
 */
class IncomeFragment : Fragment() {

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
        val root = inflater.inflate(R.layout.fragment_income, container, false)

        val save_income: View = root.findViewById(R.id.save_button_income)

        save_income.setOnClickListener{
            val type = "income"
            val income_amount = root.findViewById<EditText>(R.id.euro_income).text.toString()
            val date = root.findViewById<EditText>(R.id.date_input_field_income).text.toString()
            val account = root.findViewById<EditText>(R.id.account_input_field_income).text.toString()
            val category = root.findViewById<EditText>(R.id.category_input_field_income).text.toString()
            val description = root.findViewById<EditText>(R.id.description_input_field_income).text.toString()

            val queue = Volley.newRequestQueue(this.context)
            val url = "https://saveup.weisl.cc/userdata"

            val requestBody = "type=" + type + "&amount=" + income_amount + "&date=" + date +
                              "&account=" + account + "&category=" + category +
                              "&description=" + description

            val stringReq : StringRequest =
                    object : StringRequest(Method.POST, url,
                            Response.Listener { response ->
                                // response
                                val strResp = response.toString()

                                Log.d("API", strResp)
                                Toast.makeText(this.context, "Income stored", Toast.LENGTH_SHORT).show()
                            },
                            Response.ErrorListener { error ->
                                Log.d("API", "error => $error")
                                Toast.makeText(this.context, "Storing failed", Toast.LENGTH_SHORT).show()
                            }
                    ){
                        override fun getBody(): ByteArray {
                            return requestBody.toByteArray(Charset.defaultCharset())
                        }
                    }
            queue.add(stringReq)
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
        fun newInstance(sectionNumber: Int): IncomeFragment {
            return IncomeFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}