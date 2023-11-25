package com.rifftyo.food

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var menuFood: RecyclerView
    private val list = ArrayList<Food>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menuFood = findViewById(R.id.food_menu)
        menuFood.setHasFixedSize(true)

        list.addAll(getFoodMenu())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_about -> {
                showAboutActivity()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getFoodMenu(): ArrayList<Food> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listFood = ArrayList<Food>()
        for (i in dataName.indices) {
            val food = Food(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listFood.add(food)
        }
        return listFood
    }
    private fun showRecyclerList() {
        menuFood.layoutManager = LinearLayoutManager(this)
        val listFoodAdapter = ListFoodAdapter(list)
        menuFood.adapter = listFoodAdapter
    }

    private fun showAboutActivity() {
        val intent = Intent(this, AboutActivity::class.java)
        startActivity(intent)
    }
}