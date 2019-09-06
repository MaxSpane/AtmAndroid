package it.wemake.atmgokada.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import it.wemake.atmgokada.R
import it.wemake.atmgokada.models.Account

class ReceiptActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receipt)

        val titleTV = findViewById<TextView>(R.id.tv_title)
        val captionTV = findViewById<TextView>(R.id.tv_caption)
        val transactionType = intent.getStringExtra("transaction_type")

        when(transactionType){

            "balance_check" -> {
                val balance = intent.getParcelableExtra<Account>("account").balance
                captionTV.text = "Your Account Balance is $balance"
            }

            "withdrawal" -> {
                val balance = intent.getParcelableExtra<Account>("account").balance
                val amount = intent.getIntExtra("amount", 0)
                captionTV.text = "You have successfully withdrawn $amount.\nYour Account Balance is $balance"
                titleTV.text = transactionType.toUpperCase()
            }

            "deposit" -> {
                val balance = intent.getParcelableExtra<Account>("account").balance
                val amount = intent.getIntExtra("amount", 0)
                captionTV.text = "You have successfully deposited $amount.\nYour Account Balance is $balance"
                titleTV.text = transactionType.toUpperCase()
            }

        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_receipt, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.item_done -> {
                val intent = Intent(this, CardsActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }

    }

}
