package com.methodius.drinks.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.methodius.drinks.*
import com.methodius.drinks.adapters.DrinksAdapter
import com.methodius.drinks.api.DrinksApi
import com.methodius.drinks.api.RetrofitLab
import com.methodius.drinks.model.DrinksList
import com.methodius.drinks.model.DrinkModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DrinksActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drinks)

        var list: List<DrinkModel>
        val title: TextView = findViewById(R.id.drinks_category)

        val lab: RetrofitLab = RetrofitLab()
        val drinksApi: DrinksApi = lab.getUnit()
        val call: Call<DrinksList> = drinksApi.callDrinks("Ordinary_Drink")

        call.enqueue(object: Callback<DrinksList>{
            override fun onResponse(call: Call<DrinksList>, response: Response<DrinksList>) {
                list = response.body()?.drinksList!!
                title.text = "Ordinary Drink"
                drinksInit(list)
            }

            override fun onFailure(call: Call<DrinksList>, t: Throwable) {
                Log.d("failure", t.message.toString())
            }
        })
    }

    fun drinksInit(list: List<DrinkModel>) {
        val recyclerView: RecyclerView = findViewById(R.id.drinks_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = DrinksAdapter(list)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
         menuInflater.inflate(R.menu.menu, menu)
         return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.filters -> startActivity(Intent(this, FiltersActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }
}