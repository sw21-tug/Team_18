package com.example.saveup.ui.form

import android.app.AlertDialog
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
    private var income_check = booleanArrayOf(false, false, false)
    private val income_tags_array = arrayOf("salary", "gifts", "payback")
    private val tags_database : MutableList<String> = ArrayList()
    private lateinit var pageViewModel: PageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProvider(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    private fun showIncomeTags(){

        var count = 0
        while(count < income_check.size) {
            income_check[count] = false
            count++
        }
        count = 0

        lateinit var income_tags: AlertDialog

        val tags_store = arrayOf("0", "0", "0")
        val builder = AlertDialog.Builder(this.context)
        builder.setTitle("Choose tags")
        builder.setMultiChoiceItems(income_tags_array, income_check){dialog, which, isChecked ->
            income_check[which] = isChecked

        }




        builder.setPositiveButton("OK") { _, _ ->
            Toast.makeText(this.context,"Ok.",Toast.LENGTH_SHORT).show()
            var x = 0
            while(x < income_tags_array.size){
                if(income_check[x]){
                    tags_database.add(income_tags_array[x])
                }
                x++}
        }
        income_tags = builder.create()
        income_tags.show()
        /*income_tags.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(2)*/
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_income, container, false)

        val income_tags_button: View = root.findViewById(R.id.tags_button_income)

        income_tags_button.setOnClickListener(){
            showIncomeTags()
        }
        val save_income: View = root.findViewById(R.id.save_button_income)

        save_income.setOnClickListener{
            val type = "income"
            val income_amount = root.euro_income.text.toString()
            val date = root.date_input_field_income.text.toString()
            val account = root.account_input_field_income.text.toString()
            val category = root.category_input_field_income.text.toString()
            val description = root.description_input_field_income.text.toString()
            /*val tags */
            var x = 0
            var tags = ""
            while(x < tags_database.size){

                if(x == tags_database.size-1){
                    tags += tags_database.get(x)
                }
                else{
                    tags += tags_database.get(x) + ","

                }
                x++
            }
            Toast.makeText(this.context, tags, Toast.LENGTH_SHORT).show()


            val queue = Volley.newRequestQueue(this.context)
            val url = "https://saveup.weisl.cc/userdata"

            val requestBody = "type=" + type + "&amount=" + income_amount + "&date=" + date +
                              "&account=" + account + "&category=" + category +
                              "&description=" + description + "&tags=" + tags

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