package ru.nemov.ittestmain

internal data class ProductUI(
    val id: Int,
    val name: String,
    val time: Long,
    val tags: List<String>?,
    val amount: Int
)
