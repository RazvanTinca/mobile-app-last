package store.razvan.prepself.activity

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.GestureDetector
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main_screen.*
import store.razvan.prepself.R
import store.razvan.prepself.ViewPagerAdapter
import store.razvan.prepself.databinding.ActivityMainScreenBinding
import store.razvan.prepself.utils.*


class MainScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        test1 = findViewById(R.id.foodAttributeView)
        navigationButtonsView = findViewById(R.id.navigationButtonsView)

        test1.background = roundedCornersDrawable(
            2.dpToPixels(applicationContext), // border width in pixels
            Color.parseColor("#000000"), // border color
            30.dpToPixels(applicationContext).toFloat(), // corners radius
            Color.parseColor("#111111")
        )

        navigationButtonsView.background = roundedCornersDrawable(
            2.dpToPixels(applicationContext),
            Color.parseColor("#FFFFFF"),
            30.dpToPixels(applicationContext).toFloat(),
            Color.parseColor("#FFFFFF")
        )

        val discoveryButton = binding.menu.discoveryButton
        discoveryButton.layoutParams.width = 60.dpToPixels(this)
        discoveryButton.layoutParams.height = 60.dpToPixels(this)
        discoveryButton.background = getDrawable(R.drawable.selected_menu)

        test1.background.alpha = 95
        clickListeners()
        val adapter = ViewPagerAdapter(getRecipes()!!.body, binding, this)
        viewPager.adapter = adapter
        viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL
    }

    private fun clickListeners() {
        binding.menu.fridgeButton.setOnClickListener { openFridgeActivity(this) }
        binding.menu.cookingListButton.setOnClickListener { openRecipeListActivity(this) }
        binding.menu.checklistButton.setOnClickListener { openChecklistActivity(this) }
        binding.menu.userInfoButton.setOnClickListener { openUserProfileActivity(this) }
    }



    lateinit var test1: View
    lateinit var navigationButtonsView: View

    // extension function to get rounded corners border
    private fun roundedCornersDrawable(
        borderWidth: Int = 10, // border width in pixels
        borderColor: Int = Color.BLACK, // border color
        cornerRadius: Float = 25F, // corner radius in pixels
        bgColor: Int = Color.TRANSPARENT // view background color
    ): Drawable {
        return GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            setStroke(borderWidth, borderColor)
            setColor(bgColor)
            this.cornerRadius = cornerRadius
        }
    }
}