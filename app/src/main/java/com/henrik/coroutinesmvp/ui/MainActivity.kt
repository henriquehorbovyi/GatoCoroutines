package com.henrik.coroutinesmvp.ui

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.google.android.material.snackbar.Snackbar
import com.henrik.coroutinesmvp.R
import com.henrik.coroutinesmvp.data.entity.Gato
import com.henrik.coroutinesmvp.ui.base.ScopedActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : ScopedActivity(){

    private val viewModelFactory: MainViewModelFactory by inject()
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        atualizar_gato_button.setOnClickListener { view ->
            startObserveGato(view)
        }
    }

    private fun startObserveGato(view: View){
        launch {
            viewModel.fetch()
            val gato = viewModel.gato
            gato.await().observe(this@MainActivity, Observer {
                showLoading()
                loadGato(it, view)
            })
        }
    }

    private fun loadGato(gato: Gato, view: View){
        Glide.with(view)
            .load(gato.imagem)
            .addListener(object : RequestListener<Drawable>{
                override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                    Snackbar.make(view, "Loading error!", Snackbar.LENGTH_LONG).setAction("OK") {}
                    return false
                }
                override fun onResourceReady(resource: Drawable?, model: Any?,target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                    hideLoading()
                    return false
                }
            }).into(imagem_gato)
    }

    private fun showLoading() { carregando.visibility = View.VISIBLE }
    private fun hideLoading() { carregando.visibility = View.GONE }

}
