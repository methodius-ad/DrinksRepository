package com.methodius.drinks.model

import com.google.gson.annotations.SerializedName

data class DrinkModel(@SerializedName("strDrink") val name: String,
                      @SerializedName("strDrinkThumb") val image: String,
                      @SerializedName("idDrink") val id: String)