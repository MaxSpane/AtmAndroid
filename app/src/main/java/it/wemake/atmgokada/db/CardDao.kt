package it.wemake.atmgokada.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import it.wemake.atmgokada.models.Card
import androidx.room.Update



@Dao
interface CardDao {

    @Query("SELECT * from cards")
    fun getAllCards(): LiveData<List<Card>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCards(vararg card: Card)

    @Query("DELETE FROM cards")
    suspend fun deleteAll()

    @Update
    suspend fun updateCards(vararg card: Card)

}