package it.wemake.atmgokada.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import it.wemake.atmgokada.R
import it.wemake.atmgokada.models.Account

class ReceiptActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receipt)

        val titleTV = findViewById<TextView>(R.id.tv_title)
        val captionTV = findViewById<TextView>(R.id.tv_caption)

        when(intent.getStringExtra("transaction_type")){

            "balance_check" -> {
                val balance = intent.getParcelableExtra<Account>("account").balance
                captionTV.text = "Your Account Balance is $balance"
            }

            "withdrawal" -> {
                val balance = intent.getParcelableExtra<Account>("account")
                val amount = intent.getIntExtra("amount", 0)
                captionTV.text = "You have successfully withdrawn $amount.\nYour Account Balance is $balance"
            }

            "deposit" -> {
                val balance = intent.getParcelableExtra<Account>("account")
                val amount = intent.getIntExtra("amount", 0)
                captionTV.text = "You have successfully deposited $amount.\nYour Account Balance is $balance"
            }

        }

    }

}
