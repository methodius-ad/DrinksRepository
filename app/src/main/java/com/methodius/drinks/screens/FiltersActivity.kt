package com.methodius.drinks.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.methodius.drinks.api.DrinksApi
import com.methodius.drinks.adapters.FiltersAdapter
import com.methodius.drinks.R
import com.methodius.drinks.api.RetrofitLab
import com.methodius.drinks.model.FilterModel
import com.methodius.drinks.model.FiltersList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FiltersActivity : AppCompatActivity() {
    lateinit var checkFilter: CheckBox
    lateinit var nameFilter: TextView
    lateinit var applyButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filters)

        var list: List<FilterModel>
     //   checkFilter = findViewById(R.id.filter_check)!!
     //   nameFilter = findViewById(R.id.filter_name)
        applyButton = findViewById(R.id.apply_button)

        val lab: RetrofitLab = RetrofitLab()
        val drinksApi: DrinksApi = lab.getUnit()
        val call: Call<FiltersList> = drinksApi.callCategories("list")

        call.enqueue(object: Callback<FiltersList> {
            override fun onResponse(call: Call<FiltersList>, response: Response<FiltersList>) {
                list = response.body()?.filtersList!!
                filtersInit(list)
            }

            override fun onFailure(call: Call<FiltersList>, t: Throwable) {
                Log.d("failure", t.message.toString())
            }
        })

        applyButton.setOnClickListener(View.OnClickListener {
   //         check()
        })
    }

    fun filtersInit(list: List<FilterModel>) {
        val recyclerView: RecyclerView = findViewById(R.id.filters_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = FiltersAdapter(list, applyButton)
    }

    fun check() {
        if(checkFilter.isChecked) {
            Log.d("logs", nameFilter.text.toString())
        }
    }
    }
