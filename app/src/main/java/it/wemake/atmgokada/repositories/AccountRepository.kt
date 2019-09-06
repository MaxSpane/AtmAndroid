package it.wemake.atmgokada.repositories

import androidx.lifecycle.LiveData
import it.wemake.atmgokada.db.AccountDao
import it.wemake.atmgokada.db.CardDao
import it.wemake.atmgokada.models.Account
import it.wemake.atmgokada.models.Card

class AccountRepository(private val accountDao: AccountDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allAccountsLiveData: LiveData<List<Account>> = accountDao.getAllAccounts()

    fun getAccount(cardNumber: Int): LiveData<Account>{
        return accountDao.getAccount(cardNumber)
    }

    suspend fun insert(account: Account) {
        accountDao.insertAccounts(account)
    }

    suspend fun update(account: Account) {
        accountDao.updateAccounts(account)
    }

}