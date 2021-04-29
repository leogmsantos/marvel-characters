package br.com.leogmsantos.desafio_android_leonardo_santos

import android.app.Application
import br.com.leogmsantos.desafio_android_leonardo_santos.di.apiModule
import br.com.leogmsantos.desafio_android_leonardo_santos.di.retrofitModule
import br.com.leogmsantos.desafio_android_leonardo_santos.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@MyApp)
            modules(
                retrofitModule,
                apiModule, viewModelModule
            )
        }
    }
}