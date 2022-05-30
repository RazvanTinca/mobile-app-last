package store.razvan.prepself

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view_pager.view.*
import store.razvan.prepself.databinding.ActivityMainScreenBinding
import store.razvan.prepself.models.Recipe
import store.razvan.prepself.utils.getThumbnail

class ViewPagerAdapter(
    private var recipes: List<Recipe>,
    val binder: ActivityMainScreenBinding,
    val context: AppCompatActivity
) :
    RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {

    inner class ViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager, parent, false)
        return ViewPagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val curImage = getThumbnail(recipe = recipes[position])
        holder.itemView.ivImage.setImageBitmap(curImage)
    }

    override fun onViewDetachedFromWindow(holder: ViewPagerViewHolder) {
        super.onViewDetachedFromWindow(holder)

//        holder.itemView.layoutPosition.text = "Layout position: ${holder.layoutPosition}"
//        holder.itemView.adapterPosition.text = "Adapter position: ${holder.adapterPosition}"
//        holder.itemView.oldPosition.text = "Old position: ${holder.oldPosition}"
//        holder.itemView.position.text = "Position: ${holder.position}"


        var position = holder.layoutPosition
        if (position < 0) position = 0
        val recipe = recipes[position]
        binder.name.text = recipe.name
        binder.preptime.text =
            "Preptime: ${recipe.prepTime} | Servings: ${recipe.servings} | Dificulty: ${recipe.difficulty}"

    }

    override fun getItemCount(): Int {
        return recipes.size
    }
}