package com.andigeeky.tripmate.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName(value = "trip")
data class TripInput(
    val name: String,
    val startDate: String,
    val endDate: String
)
