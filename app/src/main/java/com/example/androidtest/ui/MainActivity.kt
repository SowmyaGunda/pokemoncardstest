package com.example.androidtest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtest.R
import com.example.androidtest.api.model.PokemonCard
import com.example.androidtest.viewmodel.PokemonCardData
import com.example.androidtest.viewmodel.PokemonCardsViewModel
import com.example.androidtest.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var  pokemonCardsViewModel : PokemonCardsViewModel
    private val observable = Observer<PokemonCardData>{
        println("sowmya"+ (it.cards?.size ?: 0))
        if(it.throwable == null) {
            runOnUiThread() {
                updateList(it.cards!!)
            }
        }else {
            showErrorDialog()
        }
    }
    private fun updateList(pokemonList : List<PokemonCard>){
        val rvAdapter = CustomAdapter(pokemonList)
        recyclerView.adapter = rvAdapter;
    }
    private fun showErrorDialog(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Warning!!")
        builder.setMessage("Something went wrong try again later")
        builder.setNeutralButton("OK") { dialog, which ->

        }
        builder.show()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var viewModelFactory = ViewModelFactory()
        pokemonCardsViewModel = ViewModelProvider(this,viewModelFactory).get(PokemonCardsViewModel::class.java)
        pokemonCardsViewModel.cardData.observe(this, observable)
        pokemonCardsViewModel.getCards()
        recyclerView = findViewById<RecyclerView>(R.id.pokemon_list)
        recyclerView.setLayoutManager( LinearLayoutManager(this));
    }

}