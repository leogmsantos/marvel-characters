package br.com.leogmsantos.desafio_android_leonardo_santos.ui.home

import android.os.Bundle
import android.view.Menu
import android.widget.GridLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.leogmsantos.desafio_android_leonardo_santos.R
import br.com.leogmsantos.desafio_android_leonardo_santos.databinding.ActivityMainBinding
import br.com.leogmsantos.desafio_android_leonardo_santos.dto.Character
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModel()
    private var characters: List<Character>? = null
    private val adapter = MainAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.vm = mainViewModel
        binding.lifecycleOwner = this

        mainViewModel.searchCharacters()

        mainViewModel.characters.observe(this, Observer {
            characters = it
            adapter.updateCharacters(characters as MutableList<Character>)
            adapter.notifyDataSetChanged()
        })

        setupRecyclerView()
    }

    private fun fill(){

    }

    private fun setupRecyclerView(){
        binding.rvCharacters.adapter = adapter
        binding.rvCharacters.layoutManager = LinearLayoutManager(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        val item = menu.findItem(R.id.m_search)
        val searchView =
            item.actionView as SearchView
        searchView.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

}