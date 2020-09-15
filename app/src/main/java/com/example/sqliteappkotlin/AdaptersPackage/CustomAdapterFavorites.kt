package com.example.sqliteappkotlin.AdaptersPackage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sqliteappkotlin.ModelsPackage.ModelFavorites
import com.example.sqliteappkotlin.R
import kotlinx.android.synthetic.main.adapter_favorites.view.*

class CustomAdapterFavorites(private var itemList: List<ModelFavorites>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.adapter_favorites, parent, false)
        return FavoritesViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as FavoritesViewHolder).bind(itemList[position])
    }

    class FavoritesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(modelFavorites: ModelFavorites) {
            itemView.title1.text = modelFavorites.title
        }
    }

    override fun getItemCount() = itemList.size

}
