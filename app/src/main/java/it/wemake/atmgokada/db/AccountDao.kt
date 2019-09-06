package it.wemake.atmgokada.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import it.wemake.atmgokada.models.Card
import androidx.room.Update
import it.wemake.atmgokada.models.Account


@Dao
interface AccountDao {

    @Query("SELECT * from accounts WHERE card_number = :cardNumber")
    fun getAccount(cardNumber: Int): LiveData<Account>

    @Query("SELECT * from accounts")
    fun getAllAccounts(): LiveData<List<Account>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAccounts(vararg accounts: Account)

    @Query("DELETE FROM accounts")
    suspend fun deleteAll()

    @Update
    suspend fun updateAccounts(vararg accounts: Account)

}