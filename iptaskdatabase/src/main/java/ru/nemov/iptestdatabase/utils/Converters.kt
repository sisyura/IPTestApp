package ru.nemov.iptestdatabase.utils

import androidx.room.TypeConverter

internal class Converters {

    @TypeConverter
    fun listStringToString(list: List<String>): String = list.toString()

    @TypeConverter
    fun stringToListString(value: String): List<String> {
        return value.split(",").map { it.trim() }
    }
}