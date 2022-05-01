package com.andigeeky.tripmate.models

import kotlinx.serialization.Serializable

val tripStorage = mutableListOf<Trip>()

@Serializable
data class Trip(
    val id: String,
    val name: String,
    val startDate: String,
    val endDate: String
)
