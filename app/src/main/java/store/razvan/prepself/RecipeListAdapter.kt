package store.razvan.prepself

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view_recipelist.view.*
import store.razvan.prepself.databinding.ActivityRecipeListBinding
import store.razvan.prepself.models.Recipe
import store.razvan.prepself.utils.getThumbnail
import store.razvan.prepself.utils.roundedCornersDrawable

class RecipeListAdapter(
    private var recipes: List<Recipe>,
    val binder: ActivityRecipeListBinding,
    val context: AppCompatActivity
) : RecyclerView.Adapter<RecipeListAdapter.RecipeListViewHolder>() {

    inner class RecipeListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecipeListAdapter.RecipeListViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_view_recipelist, parent, false)
        return RecipeListViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeListAdapter.RecipeListViewHolder, position: Int) {
        val curImage = getThumbnail(recipe = recipes[position])

        val itemColor: Int = Color.parseColor("#363636")
        val easyColor: Int = Color.parseColor("#63bf21")
        val normalColor: Int = Color.parseColor("#f0d85d")
        val hardColor: Int = Color.parseColor("#fc7005")
        val expertColor: Int = Color.parseColor("#fc1a05")


        holder.itemView.recipelistitem_separator.background = roundedCornersDrawable(
            0,
            Color.parseColor("#FFFFFF"),
            cornerRadius = 5f,
            Color.parseColor("#FFFFFF")
        )
        holder.itemView.recipelistitem_view.background =
            roundedCornersDrawable(5, itemColor, cornerRadius = 25f, itemColor)
        holder.itemView.recipelistitem_text.text = recipes[position].name.toString()
        holder.itemView.recipelistitem_image.setImageBitmap(curImage)
        holder.itemView.recipelistitem_description.text = recipes[position].description.toString()

        if (recipes[position].difficulty.equals("EASY")) {
            holder.itemView.recipelistitem_difficultyview.background =
                roundedCornersDrawable(10, itemColor, cornerRadius = 25f, easyColor)
        } else if (recipes[position].difficulty.equals("MEDIUM")) {
            holder.itemView.recipelistitem_difficultyview.background =
                roundedCornersDrawable(10, itemColor, cornerRadius = 25f, normalColor)
        } else if (recipes[position].difficulty.equals("HARD")) {
            holder.itemView.recipelistitem_difficultyview.background =
                roundedCornersDrawable(10, itemColor, cornerRadius = 25f, hardColor)
        } else if (recipes[position].difficulty.equals("EXPERT")) {
            holder.itemView.recipelistitem_difficultyview.background =
                roundedCornersDrawable(10, itemColor, cornerRadius = 25f, expertColor)
        }

        //holder.itemView.ivImage.setImageBitmap(curImage)
        //holder.itemView.recipeId.text = "$position"
    }

    override fun getItemCount(): Int {
        Log.e("recipes number", recipes.size.toString())
        return recipes.size
    }

}

