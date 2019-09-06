package it.wemake.atmgokada.models

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cards")
class Card(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "card_number") val cardNumber: Int,
    @ColumnInfo(name = "pin") val pin: Int,
    @ColumnInfo(name = "number_of_consecutive_tries") var numberOfConsecutiveTries: Int,
    @ColumnInfo(name = "account_name") val accountName: String
): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()!!
    )

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeInt(cardNumber)
        dest?.writeInt(pin)
        dest?.writeInt(numberOfConsecutiveTries)
        dest?.writeString(accountName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Card> {
        override fun createFromParcel(parcel: Parcel): Card {
            return Card(parcel)
        }

        override fun newArray(size: Int): Array<Card?> {
            return arrayOfNulls(size)
        }
    }
}