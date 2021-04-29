package br.com.leogmsantos.desafio_android_leonardo_santos.di


import br.com.leogmsantos.desafio_android_leonardo_santos.ui.home.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MainViewModel(get())
    }
}