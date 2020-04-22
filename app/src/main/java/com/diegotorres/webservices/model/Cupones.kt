package com.diegotorres.webservices.model


import com.google.gson.annotations.SerializedName

data class Cupones(
    @SerializedName("offers")
    val offers: List<Offer>,
    @SerializedName("result")
    val result: Boolean
)