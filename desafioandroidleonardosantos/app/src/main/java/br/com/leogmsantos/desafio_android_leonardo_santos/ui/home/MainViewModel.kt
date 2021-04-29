package br.com.leogmsantos.desafio_android_leonardo_santos.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.leogmsantos.desafio_android_leonardo_santos.BuildConfig
import br.com.leogmsantos.desafio_android_leonardo_santos.data.local.response.CharactersResponse
import br.com.leogmsantos.desafio_android_leonardo_santos.data.local.response.DataResponse
import br.com.leogmsantos.desafio_android_leonardo_santos.data.remote.APIServices
import br.com.leogmsantos.desafio_android_leonardo_santos.dto.Character
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel (private val api: APIServices) : ViewModel() {

    private val _characters = MutableLiveData<List<Character>>()
    val characters: LiveData<List<Character>> get() = _characters

    fun searchCharacters(){
        var call = api.getCharacters()
        call.enqueue(object : Callback<DataResponse>{
            override fun onFailure(call: Call<DataResponse>, t: Throwable) {
                Log.e("Failure", t.message.toString())
            }
            override fun onResponse(call: Call<DataResponse>, response: Response<DataResponse>) {
                if (response.isSuccessful){
                    _characters.value = response.body()?.data?.characters
                }
            }
        })
    }
}