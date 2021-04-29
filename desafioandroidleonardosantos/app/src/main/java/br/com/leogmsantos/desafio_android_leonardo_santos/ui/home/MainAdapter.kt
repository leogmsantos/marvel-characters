package br.com.leogmsantos.desafio_android_leonardo_santos.ui.home

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.leogmsantos.desafio_android_leonardo_santos.dto.Character

class MainAdapter (private val context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var characters: MutableList<Character> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MainViewHolder.inflate(parent)
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder){
            is MainViewHolder -> {
                holder.bind(characters[position], context)
            }
        }
    }

    fun updateCharacters(characters: MutableList<Character>){
        this.characters = characters
    }
}