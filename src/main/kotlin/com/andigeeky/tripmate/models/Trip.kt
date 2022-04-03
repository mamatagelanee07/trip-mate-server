package com.andigeeky.tripmate.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

val tripStorage = mutableListOf<Trip>()

@Serializable
data class Trip(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("start_date")
    val startDate: String,
    @SerialName("end_date")
    val endDate: String
)
