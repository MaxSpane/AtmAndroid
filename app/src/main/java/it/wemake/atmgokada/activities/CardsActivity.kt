package it.wemake.atmgokada.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import it.wemake.atmgokada.R
import it.wemake.atmgokada.adapters.CardsAdapter
import it.wemake.atmgokada.viewModels.CardsViewModel

class CardsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards)

        val cardsRV = findViewById<RecyclerView>(R.id.rv_cards)
        val cardsAdapter = CardsAdapter(this)
        cardsRV.adapter = cardsAdapter
        cardsRV.layoutManager = LinearLayoutManager(this)
        val cardsViewModel = ViewModelProviders.of(this).get(CardsViewModel::class.java)

        cardsViewModel.allCardsLiveData.observe(this, Observer { cards ->
            cards?.let { cardsAdapter.refill(it) }
        })

    }

}
