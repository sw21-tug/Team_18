import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.saveup.R
import com.example.saveup.ui.form.FormData
import kotlinx.android.synthetic.main.form_data_layout.view.*

class ListAdapter(val context: Context, val items: ArrayList<FormData>) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val formDate: TextView = view.form_date
        val formDescription: TextView = view.form_description
        val formAmount: TextView = view.form_amount
        val formTags: TextView = view.form_tags
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.form_data_layout, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items[position]

        holder.formDate.text = item.date
        holder.formDescription.text = item.description
        holder.formAmount.text = item.amount.toString()
        if(item.tags != "null") { // null comes as string
            holder.formTags.text = item.tags
        } else {
            holder.formTags.text = context.resources.getString(R.string.no_tags)
        }

        if (item.type == "income")
            holder.formAmount.setTextColor(context.resources.getColor(R.color.dark_green))
        else if (item.type == "expense")
            holder.formAmount.setTextColor(context.resources.getColor(R.color.wine))
    }

    override fun getItemCount(): Int {
        return items.size
    }
}