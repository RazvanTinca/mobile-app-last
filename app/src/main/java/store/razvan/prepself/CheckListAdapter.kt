package store.razvan.prepself

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view_checklist.view.*
import store.razvan.prepself.databinding.ActivityChecklistBinding
import store.razvan.prepself.models.Recipe

class CheckListAdapter(
    private var recipes: List<Recipe>,
    val binder: ActivityChecklistBinding,
    val context: AppCompatActivity
) : RecyclerView.Adapter<CheckListAdapter.CheckListViewHolder>() {

    inner class CheckListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CheckListAdapter.CheckListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view_checklist, parent, false)
        return CheckListViewHolder(view)
    }

    override fun onBindViewHolder(holder: CheckListAdapter.CheckListViewHolder, position: Int) {
        holder.itemView.checklist_checkbox.text = recipes[position].name.toString()
    }

    override fun getItemCount(): Int {
        Log.e("checklist things number", recipes.size.toString())
        return recipes.size
    }

}

