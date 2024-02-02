package com.serranoie.wishin.presentation.onboarding

import androidx.annotation.DrawableRes
import com.serranoie.wishin.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int,
)

val pages = listOf(
    Page(
        title = "postulant pulvinar doctus vivendo solet",
        description = "Signiferumque cras dicta quas populo non posse. Erroribus senserit interesset porttitor lacinia option.",
        image = R.drawable.onboarding_wish,
    ),
    Page(
        title = "postulant pulvinar doctus vivendo solet",
        description = "Signiferumque cras dicta quas populo non posse. Erroribus senserit interesset porttitor lacinia option.",
        image = R.drawable.onboarding_saving,
    )
)
