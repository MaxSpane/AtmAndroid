package it.wemake.atmgokada.models

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "accounts")
class Account(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "account_number") val accountNumber: Int,
    @ColumnInfo(name = "card_number") val cardNumber: Int,
    @ColumnInfo(name = "balance") var balance: Int,
    @ColumnInfo(name = "account_type") val accountType: String
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(accountNumber)
        parcel.writeInt(cardNumber)
        parcel.writeInt(balance)
        parcel.writeString(accountType)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Account> {
        override fun createFromParcel(parcel: Parcel): Account {
            return Account(parcel)
        }

        override fun newArray(size: Int): Array<Account?> {
            return arrayOfNulls(size)
        }
    }
}