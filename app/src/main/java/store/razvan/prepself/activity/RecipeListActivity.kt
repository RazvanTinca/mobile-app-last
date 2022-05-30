package store.razvan.prepself.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import store.razvan.prepself.R
import store.razvan.prepself.databinding.ActivityRecipeListBinding
import store.razvan.prepself.utils.*

class RecipeListActivity : AppCompatActivity() {


    private lateinit var binding: ActivityRecipeListBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)
        binding = ActivityRecipeListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val button = binding.menu.cookingListButton
        button.layoutParams.width = 60.dpToPixels(this)
        button.layoutParams.height = 60.dpToPixels(this)
        button.background = getDrawable(R.drawable.selected_menu)

        clickListeners()
    }


    private fun clickListeners() {
        binding.menu.fridgeButton.setOnClickListener{ openFridgeActivity(this) }
        binding.menu.discoveryButton.setOnClickListener { openDiscoveryActivity(this) }
        binding.menu.checklistButton.setOnClickListener { openChecklistActivity(this) }
        binding.menu.userInfoButton.setOnClickListener { openUserProfileActivity(this) }
    }
}