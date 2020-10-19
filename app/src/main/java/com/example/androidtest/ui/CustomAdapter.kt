package com.example.androidtest.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtest.R
import com.example.androidtest.api.model.PokemonCard

class CustomAdapter(private val pokemonList: List<PokemonCard>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0.context).inflate(R.layout.list_item_view, p0, false)
        return ViewHolder(v)
    }
    override fun getItemCount(): Int {
        return pokemonList.size
    }
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

        p0.name?.text = pokemonList[p1].name
        p0.hp?.text = pokemonList[p1].hp.toString()
        p0.evolvesfrom?.text = pokemonList[p1].evolvesFrom

    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.title)
        val hp = itemView.findViewById<TextView>(R.id.hp)
        val evolvesfrom = itemView.findViewById<TextView>(R.id.evolves_from)
    }
}