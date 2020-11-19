package com.methodius.drinks.model

import com.google.gson.annotations.SerializedName

data class FiltersList(@SerializedName("drinks") val filtersList: List<FilterModel>)