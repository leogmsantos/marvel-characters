package br.com.leogmsantos.desafio_android_leonardo_santos.ui.home

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.leogmsantos.desafio_android_leonardo_santos.databinding.ItemCharacterBinding
import br.com.leogmsantos.desafio_android_leonardo_santos.dto.Character
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

class MainViewHolder(private val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun inflate(parent: ViewGroup) : MainViewHolder {
            return MainViewHolder(ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }

    fun bind(character: Character, context: Context){
        binding.tvCharacterName.text = character.name
        binding.tvCharacterDescription.text = character.description

        var url = character.thumbnail?.path + character.thumbnail?.extension
        Log.i("Kurisu", url)
        Glide.with(context).
        load(character.thumbnail?.path + "." + character.thumbnail?.extension).
        into(binding.ivPerfilCharacter)
    }

}