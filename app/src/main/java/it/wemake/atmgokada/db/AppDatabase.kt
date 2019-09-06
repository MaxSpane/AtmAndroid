package it.wemake.atmgokada.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import it.wemake.atmgokada.models.Account
import it.wemake.atmgokada.models.Card

@Database(entities = [Card::class, Account::class], version = 1)
public abstract class AppDatabase : RoomDatabase() {

    abstract fun cardDao(): CardDao
    abstract fun accountDao(): AccountDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "atm_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}