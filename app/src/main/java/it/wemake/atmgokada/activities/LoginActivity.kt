package it.wemake.atmgokada.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import it.wemake.atmgokada.R
import it.wemake.atmgokada.models.Card
import it.wemake.atmgokada.viewModels.CardsViewModel

class LoginActivity : AppCompatActivity() {

    var card: Card? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val cardViewModel = ViewModelProviders.of(this).get(CardsViewModel::class.java)
        card = intent.getParcelableExtra("card")
        val pinET = findViewById<EditText>(R.id.et_pin)
        val welcomeTV = findViewById<TextView>(R.id.tv_welcome)
        val confirmBTN = findViewById<Button>(R.id.btn_confirm)

        welcomeTV.text = "Welcome, ${card!!.accountName}"

        confirmBTN.setOnClickListener{

            val pin = pinET.text.toString()

            if (pin.length < 4){
                Toast.makeText(this, "Enter 4 digits", Toast.LENGTH_SHORT).show()
            }else if (card!!.numberOfConsecutiveTries >= 3){
                Toast.makeText(this, "You have made the maximum attempts of 3 on this Card. Contact your Bank to regain access.", Toast.LENGTH_SHORT).show()
            }else if (Integer.parseInt(pin) == card!!.pin){
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
                if (card!!.numberOfConsecutiveTries > 0){
                    card!!.numberOfConsecutiveTries = 0
                    cardViewModel.update(card!!)
                }

                val intent = Intent(this, ChooseOperationActivity::class.java)
                intent.putExtra("card_number", card!!.cardNumber)
                startActivity(intent)

            }else{
                Toast.makeText(this, "Incorrect pin, ${3 - card!!.numberOfConsecutiveTries} attempts left", Toast.LENGTH_SHORT).show()
                card!!.numberOfConsecutiveTries++
                cardViewModel.update(card!!)
            }

        }

    }

}
