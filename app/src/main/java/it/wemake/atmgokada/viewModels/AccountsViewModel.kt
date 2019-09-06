package it.wemake.atmgokada.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import it.wemake.atmgokada.db.AppDatabase
import it.wemake.atmgokada.models.Account
import it.wemake.atmgokada.models.Card
import it.wemake.atmgokada.repositories.AccountRepository
import it.wemake.atmgokada.repositories.CardRepository
import kotlinx.coroutines.launch

class AccountsViewModel(application: Application) : AndroidViewModel(application) {

    // The ViewModel maintains a reference to the repository to get data.
    private val repository: AccountRepository
    // LiveData gives us updated words when they change.
    val allAccountsLiveData: LiveData<List<Account>>

    init {
        val accountDao = AppDatabase.getDatabase(application).accountDao()
        repository = AccountRepository(accountDao)
        allAccountsLiveData = repository.allAccountsLiveData
    }

    fun insert(account: Account) = viewModelScope.launch {
        repository.insert(account)
    }

    fun update(account: Account) = viewModelScope.launch {
        repository.update(account)
    }

    fun getAccount(account: Account) = viewModelScope.launch {
        repository.update(account)
    }

}
