package it.wemake.atmgokada.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import it.wemake.atmgokada.R
import it.wemake.atmgokada.db.DemoData
import it.wemake.atmgokada.models.Account
import it.wemake.atmgokada.models.Card
import it.wemake.atmgokada.viewModels.AccountsViewModel
import it.wemake.atmgokada.viewModels.CardsViewModel

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        if (getSharedPreferences("atm", Context.MODE_PRIVATE).getBoolean("isFirstLaunch", true)){
            //Populate db with demo data
            val cardsViewModel = ViewModelProviders.of(this).get(CardsViewModel::class.java)
            val accountsViewModel = ViewModelProviders.of(this).get(AccountsViewModel::class.java)

            for (card: Card in DemoData.getCards()){
                cardsViewModel.insert(card)
            }

            for (account: Account in DemoData.getAccounts()){
                accountsViewModel.insert(account)
            }

            getSharedPreferences("atm", Context.MODE_PRIVATE).edit().putBoolean("isFirstLaunch", false).apply()
        }

        val intent = Intent(this, CardsActivity::class.java)
        startActivity(intent)

    }

}
