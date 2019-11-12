package com.example.submisi.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.submisi.model.FootbalClub
import com.example.submisi.ui.list.Football
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.AnkoContext

//TODO CREATE 2. ADAPTER
class AdapterFootball(private val context: Context,
                      private val items: List<FootbalClub>,
                      private val listener: (FootbalClub) -> Unit):
    RecyclerView.Adapter<AdapterFootball.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            Football().createView(AnkoContext.create(parent.context, parent))
        )

    override fun getItemCount(): Int = items.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        var tvTitle: TextView
        var gambar: ImageView

        init {
            tvTitle = itemView.findViewById(Football.tvTitleId)
            gambar = itemView.findViewById(Football.iVimage)
        }

        fun bindItem(items: FootbalClub, listener: (FootbalClub) -> Unit) {
            tvTitle.text = items.nameFootbal
            //jika items.image kosong isi dengan load picasso
            items.nameImage?.let { Picasso.get().load(it).fit().into(gambar) }
            itemView.setOnClickListener {
                listener(items)
            }
        }
    }
}