package com.methodius.drinks.api

import com.methodius.drinks.Values
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitLab {

    fun getUnit(): DrinksApi {
        // https://www.thecocktaildb.com/api/json/v1/1/filter.php?c=Ordinary_Drink
        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(Values.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        return  retrofit.create(DrinksApi::class.java)
    }
}