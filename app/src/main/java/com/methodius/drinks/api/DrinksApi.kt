package com.methodius.drinks.api

import com.methodius.drinks.Values
import com.methodius.drinks.model.DrinksList
import com.methodius.drinks.model.FiltersList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinksApi {
    @GET(Values.GET_FILTER)
    fun callDrinks(@Query(Values.C_KEY) category: String): Call<DrinksList>
    @GET(Values.GET_LIST)
    fun callCategories(@Query(Values.C_KEY) category: String): Call<FiltersList>
}