package ru.nemov.iptestdatabase.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProductDBO(
    @PrimaryKey(false) @ColumnInfo("id") val id: Int,
    @ColumnInfo("name") val name: String,
    @ColumnInfo("time") val time: Long,
    @ColumnInfo("tags") val tags: List<String>?,
    @ColumnInfo("amount") val amount: Int
)
