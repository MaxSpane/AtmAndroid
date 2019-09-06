package it.wemake.atmgokada.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import it.wemake.atmgokada.R
import it.wemake.atmgokada.models.Account
import it.wemake.atmgokada.viewModels.AccountsViewModel

class ChooseOperationActivity : AppCompatActivity() {

    var account: Account? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_operation)

        val cardNumber = intent.getIntExtra("card_number", 0)
        ViewModelProviders.of(this).get(AccountsViewModel::class.java)
            .getAccount(cardNumber)
            .observe(this, Observer { account -> this.account = account })

        val checkBalanceBTN = findViewById<Button>(R.id.btn_check_balance)
        val withdrawBTN = findViewById<Button>(R.id.btn_withdraw)
        val depositBTN = findViewById<Button>(R.id.btn_deposit)

        checkBalanceBTN.setOnClickListener{
            val intent = Intent(this, ReceiptActivity::class.java)
            intent.putExtra("transaction_type", "balance_check")
            intent.putExtra("account", account)
            startActivity(intent)
        }

        withdrawBTN.setOnClickListener{
            val intent = Intent(this, PerformOperationActivity::class.java)
            intent.putExtra("transaction_type", "withdrawal")
            intent.putExtra("account", account)
            startActivity(intent)
        }

        depositBTN.setOnClickListener{
            val intent = Intent(this, PerformOperationActivity::class.java)
            intent.putExtra("transaction_type", "deposit")
            intent.putExtra("account", account)
            startActivity(intent)
        }

    }

}
