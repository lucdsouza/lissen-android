package org.grakovne.lissen.lib.domain

import androidx.annotation.Keep

@Keep
data class PlayingHistoryItem(
	val title: String,
	val chapterPosition: Double,
	val totalPosition: Double
)