package it.wemake.atmgokada.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "accounts")
class Account(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "account_number") val accountNumber: Int,
    @ColumnInfo(name = "card_number") val cardNumber: Int,
    @ColumnInfo(name = "balance") val balance: Int,
    @ColumnInfo(name = "account_type") val accountType: Int
)