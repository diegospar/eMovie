package com.example.mvvmapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.mvvmapp.data.model.ContainerModel
import com.example.mvvmapp.databinding.ActivityMainBinding
import com.example.mvvmapp.ui.viewmodel.ContainerViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val containerViewModel:ContainerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        containerViewModel.onCreate()

        containerViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible = it
        })

        containerViewModel.containerModel.observe(this, androidx.lifecycle.Observer { CurrentContainer ->
            binding.tvTipo.text = concatenarTipos(CurrentContainer)
            binding.tvDireccion.text = concatenarDirecciones(CurrentContainer)
        })



    }

    fun concatenarTipos(currentContainer:List<ContainerModel>):String{
        var result= ""
        currentContainer.forEach {
            result= result + " " +it.tipo
        }
        return result
    }

    fun concatenarDirecciones(currentContainer:List<ContainerModel>):String{
        var result= ""
        currentContainer.forEach {
            result= result + " " +it.direccion
        }
        return result
    }

}