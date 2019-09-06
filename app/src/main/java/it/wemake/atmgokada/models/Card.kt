package it.wemake.atmgokada.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cards")
class Card(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "card_number") val cardNumber: Int,
    @ColumnInfo(name = "pin") val pin: Int,
    @ColumnInfo(name = "number_of_consecutive_tries") val numberOfConsecutiveTries: Int,
    @ColumnInfo(name = "account_name") val accountName: String
)