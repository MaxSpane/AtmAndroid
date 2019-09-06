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
import it.wemake.atmgokada.models.Account
import it.wemake.atmgokada.viewModels.AccountsViewModel

class PerformOperationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perform_operation)

        val transactionType = intent.getStringExtra("transaction_type")
        val accountViewModel = ViewModelProviders.of(this).get(AccountsViewModel::class.java)
        val account = intent.getParcelableExtra<Account>("account")

        val operationTitleTV = findViewById<TextView>(R.id.tv_operation_title)
        val amountET = findViewById<EditText>(R.id.et_amount)
        val confirmBTN = findViewById<Button>(R.id.btn_confirm)

        when(transactionType){

            "withdrawal" -> operationTitleTV.text = getString(R.string.how_much_withdraw_title)

            "deposit" -> operationTitleTV.text = getString(R.string.how_much_deposit_title)

        }

        confirmBTN.setOnClickListener {

            val amount = Integer.parseInt(amountET.text.toString())

            val showReceipt = {

                val intent = Intent(this, ReceiptActivity::class.java)
                intent.putExtra("amount", amount)
                intent.putExtra("account", account)
                intent.putExtra("transaction_type", transactionType)
                startActivity(intent)

            }

            when(transactionType){

                "withdrawal" -> {

                    if (amount > account.balance){
                        Toast.makeText(this, getString(R.string.insufficient_funds), Toast.LENGTH_SHORT).show()
                    }else{
                        account.balance -= amount
                        accountViewModel.update(account)
                        showReceipt()
                    }

                }

                "deposit" -> {
                    account.balance += amount
                    accountViewModel.update(account)
                    showReceipt()
                }

            }


        }

    }

}
