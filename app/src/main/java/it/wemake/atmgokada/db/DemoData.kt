package it.wemake.atmgokada.db

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import it.wemake.atmgokada.models.Account
import it.wemake.atmgokada.models.Card
import it.wemake.atmgokada.repositories.AccountRepository
import kotlinx.coroutines.launch

class DemoData(){

    companion object{

        @Volatile
        private var cards: Array<Card>? = null

        @Volatile
        private var accounts: Array<Account>? = null

        fun getCards(): Array<Card>{

            if (cards == null){
                cards = arrayOf(Card(1, 1234, 0, "Card User Uno"), Card(2, 2345, 0, "Card User Deux"), Card(3, 3456, 0, "Card User Eketa"))
            }

            return cards!!

        }

        fun getAccounts(): Array<Account>{

            if (accounts == null){
                accounts = arrayOf(Account(1, 1, 100000, "Savings"), Account(2, 2, 20000, "Savings"), Account(3, 3, 3000000, "Savings"))
            }

            return accounts!!

        }
    }


}