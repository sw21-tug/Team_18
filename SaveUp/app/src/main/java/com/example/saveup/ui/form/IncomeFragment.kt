package com.example.saveup.ui.form

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.saveup.R
import java.nio.charset.Charset
import kotlinx.android.synthetic.main.fragment_income.view.*


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
            val income_amount = root.euro_income.text.toString()
            val date = root.date_input_field_income.text.toString()
            val account = root.account_input_field_income.text.toString()
            val category = root.category_input_field_income.text.toString()
            val description = root.description_input_field_income.text.toString()

            val sharedPref: SharedPreferences = this.activity!!.getSharedPreferences("User", Context.MODE_PRIVATE)
            val token = sharedPref.getString("user_token", null)

            val queue = Volley.newRequestQueue(this.context)
            val url = "https://saveup.weisl.cc/userdata"

            val requestBody = "token=" + token + "&type=" + type + "&amount=" + income_amount + "&date=" + date +
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

            root.euro_income.text.clear()
            root.date_input_field_income.text.clear()
            root.account_input_field_income.text.clear()
            root.category_input_field_income.text.clear()
            root.description_input_field_income.text.clear()
        }

        return root
    }

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"

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