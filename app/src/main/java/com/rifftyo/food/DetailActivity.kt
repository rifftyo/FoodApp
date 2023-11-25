package com.rifftyo.food

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    private lateinit var detailNameFood: TextView
    private lateinit var detailDeskripsiFood: TextView
    private lateinit var detailImgFood: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        detailNameFood = findViewById(R.id.detail_name_food)
        detailDeskripsiFood = findViewById(R.id.detail_deskripsi_food)
        detailImgFood = findViewById(R.id.detail_food_foto)

        val dataFood = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Food>(ListFoodAdapter.KEY_FOOD, Food::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Food>(ListFoodAdapter.KEY_FOOD)
        }
        dataFood?.let {
            detailNameFood.text = it.name
            detailDeskripsiFood.text = it.description
            detailImgFood.setImageResource(it.photo)
        }
    }
}