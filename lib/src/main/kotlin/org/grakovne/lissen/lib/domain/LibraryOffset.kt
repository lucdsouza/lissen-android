package org.grakovne.lissen.lib.domain

import androidx.annotation.Keep
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class LibraryOffset(
	val libraryId: String,
	val offset: Int
)