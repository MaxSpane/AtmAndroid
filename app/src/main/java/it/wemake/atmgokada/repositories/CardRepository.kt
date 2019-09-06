package it.wemake.atmgokada.repositories

import androidx.lifecycle.LiveData
import it.wemake.atmgokada.db.CardDao
import it.wemake.atmgokada.models.Card

class CardRepository(private val cardDao: CardDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allCardsLiveData: LiveData<List<Card>> = cardDao.getAllCards()


    // The suspend modifier tells the compiler that this must be called from a
    // coroutine or another suspend function.
    suspend fun insert(card: Card) {
        cardDao.insertCards(card)
    }

    suspend fun update(card: Card) {
        cardDao.updateCards(card)
    }

}