package com.methodius.drinks.model

import com.google.gson.annotations.SerializedName

data class FilterModel(@SerializedName("strCategory") val category: String)