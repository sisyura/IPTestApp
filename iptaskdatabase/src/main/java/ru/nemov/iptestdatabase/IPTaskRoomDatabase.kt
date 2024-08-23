package ru.nemov.iptestdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.nemov.iptestdatabase.dao.ProductDao
import ru.nemov.iptestdatabase.models.ProductDBO
import ru.nemov.iptestdatabase.utils.Converters

class IPTaskDatabase internal constructor(private val database: IPTaskRoomDatabase) {

    val productsDao: ProductDao
        get() = database.productsDao()
}

@Database(entities = [ProductDBO::class], version = 1)
@TypeConverters(Converters::class)
internal abstract class IPTaskRoomDatabase : RoomDatabase() {

    abstract fun productsDao(): ProductDao
}

fun IPTaskDatabase(applicationContext: Context): IPTaskDatabase {
    val ipTaskRoomDatabase = Room.databaseBuilder(
        checkNotNull(applicationContext.applicationContext),
        IPTaskRoomDatabase::class.java,
        "iptask"
    )
        .createFromAsset("databases/data.db")
        .build()
    return IPTaskDatabase(ipTaskRoomDatabase)
}