package com.yah.ph3project3.network

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "images")
data class DogPhoto (
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    val id: Int? = null,

    @ColumnInfo(name = "image")
    @Json(name = "message")
    val imageUrl: String?,

    @Json(name = "status") val statusResponse: String?
)

