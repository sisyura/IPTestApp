package ru.nemov.ittask.data.model

data class Product(
    val id: Int,
    val name: String,
    val time: Long,
    val tags: List<String>?,
    val amount: Int
)