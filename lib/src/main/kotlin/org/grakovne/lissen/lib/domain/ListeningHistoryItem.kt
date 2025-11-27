package org.grakovne.lissen.lib.domain

import androidx.annotation.Keep

@Keep
data class ListeningHistoryItem(
  val title: String,
  val position: Int,
)