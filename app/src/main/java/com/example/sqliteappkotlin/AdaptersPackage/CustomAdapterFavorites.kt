package com.example.sqliteappkotlin.AdaptersPackage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sqliteappkotlin.ModelsPackage.ModelFavorites
import com.example.sqliteappkotlin.R
import kotlinx.android.synthetic.main.adapter_favorites.view.*

class CustomAdapterFavorites(private var partItemList: List<ModelFavorites>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.adapter_favorites, parent, false)
        return PartViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PartViewHolder).bind(partItemList[position])
    }

    class PartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(part: ModelFavorites) {
            itemView.title1.text = part.title
        }
    }

    override fun getItemCount() = partItemList.size

}