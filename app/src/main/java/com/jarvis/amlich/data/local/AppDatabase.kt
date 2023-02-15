package com.jarvis.amlich.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jarvis.amlich.data.entity.*
import com.jarvis.amlich.data.local.AppDatabase.Companion.DATABASE_VERSION
import com.jarvis.amlich.data.local.dao.QueDao

@Database(
    entities = [
        BuonBanEntity::class,
        DoanBenhEntity::class,
        GiaDaoEntity::class,
        HonNhanEntity::class,
        KienTungEntity::class,
        LucSucEntity::class,
        MuuVongEntity::class,
        NguoiDiEntity::class,
        QueEntity::class,
        ThatVatEntity::class,
        TuoiMangEntity::class,
        VanKhanEntity::class,
    ],
    version = DATABASE_VERSION,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun queDao(): QueDao

    companion
    object {
        const val DATABASE_VERSION = 1
        private const val DB_NAME = "db_app.db"

        fun build(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
                .createFromAsset(DB_NAME)
                .build()
    }
}
