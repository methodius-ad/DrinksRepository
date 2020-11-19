package com.methodius.drinks.model

import com.google.gson.annotations.SerializedName

data class DrinksList(@SerializedName("drinks") val drinksList: List<DrinkModel>)