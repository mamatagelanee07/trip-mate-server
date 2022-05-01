package com.andigeeky.tripmate.models

import kotlinx.serialization.Serializable

@Serializable
data class TripInput(
    val name: String,
    val startDate: String,
    val endDate: String
)
