package com.benrostudios.xpenso

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class rec_adapter(private val list: List<trans_frag.Transactions>,val listener: (Int) -> Unit)
    : RecyclerView.Adapter<TransViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TransViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: TransViewHolder, position: Int) {
        val transaction: trans_frag.Transactions = list[position]
        holder.bind(transaction,position,listener)
    }

    override fun getItemCount(): Int = list.size

}

class TransViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.sampleholder, parent, false)) {

    private var mTitleView: TextView? = null
    private var mDateView: TextView? = null
    private var mAmtView: TextView? = null
    private var imageView: ImageView


    init {
        mTitleView = itemView.findViewById(R.id.HeadName)
        mDateView = itemView.findViewById(R.id.datedisp)
        mAmtView = itemView.findViewById(R.id.mondisp)
        imageView = itemView.findViewById(R.id.randimg)
    }

    fun bind(transaction: trans_frag.Transactions,pos: Int, listener: (Int) -> Unit) = with(itemView) {
        mTitleView?.text = transaction.title
        mDateView?.text = transaction.year
        mAmtView?.text = transaction.amount.toString()
        imageView.setImageResource(R.drawable.avatar)
        val cvItem = findViewById(R.id.cvItem) as CardView
        cvItem.setOnClickListener {
            listener(pos)
        }

    }


}