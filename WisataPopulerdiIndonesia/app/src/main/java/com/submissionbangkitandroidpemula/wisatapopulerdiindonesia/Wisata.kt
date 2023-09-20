package com.submissionbangkitandroidpemula.wisatapopulerdiindonesia

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Wisata(
    val name: String,
    val description: String,
    val photo: Int,
    val alamat: String
) : Parcelable
