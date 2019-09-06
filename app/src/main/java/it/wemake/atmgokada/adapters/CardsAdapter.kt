package it.wemake.atmgokada.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import it.wemake.atmgokada.R
import it.wemake.atmgokada.models.Card

class CardsAdapter(

    private val context : Context

) : RecyclerView.Adapter<CardsAdapter.ViewHolder>(){

    private var cards = emptyList<Card>()

    override fun getItemCount() = cards.size

    override fun onBindViewHolder(holder: CardsAdapter.ViewHolder, position: Int) {

        val card = cards[position]

        holder.accountNameTV.text = card.accountName
        holder.pinTV.text = "PIN: \$ ${card.pin}"

    }

    fun refill(newDataset: List<Card>){
        cards = newDataset
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): CardsAdapter.ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.item_card, parent, false)
        return ViewHolder(view)

    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val accountNameTV : TextView = itemView.findViewById(R.id.tv_account_name)
        val pinTV : TextView = itemView.findViewById(R.id.tv_pin)

    }

}