package it.wemake.atmgokada.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import it.wemake.atmgokada.db.AppDatabase
import it.wemake.atmgokada.models.Card
import it.wemake.atmgokada.repositories.CardRepository
import kotlinx.coroutines.launch

class CardsViewModel(application: Application) : AndroidViewModel(application) {

    // The ViewModel maintains a reference to the repository to get data.
    private val repository: CardRepository
    // LiveData gives us updated words when they change.
    val allCardsLiveData: LiveData<List<Card>>

    init {
        val cardDao = AppDatabase.getDatabase(application).cardDao()
        repository = CardRepository(cardDao)
        allCardsLiveData = repository.allCardsLiveData
    }

    fun insert(card: Card) = viewModelScope.launch {
        repository.insert(card)
    }

}
