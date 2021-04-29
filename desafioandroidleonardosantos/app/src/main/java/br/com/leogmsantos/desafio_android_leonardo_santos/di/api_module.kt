package br.com.leogmsantos.desafio_android_leonardo_santos.di


import br.com.leogmsantos.desafio_android_leonardo_santos.data.remote.APIServices
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single(createdAtStart = false) {
        get<Retrofit>().create(APIServices::class.java)
    }
}