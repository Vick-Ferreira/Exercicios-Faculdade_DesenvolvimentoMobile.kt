package com.grud.testerecyrcle.ui

import android.os.Bundle
import android.widget.Adapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.grud.testerecyrcle.MyAdapter
import com.grud.testerecyrcle.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    //configuração iniciar do Binding
    private lateinit var binding: ActivityMainBinding

    private val dataList = mutableListOf<String>() // Crie uma lista mutável para armazenar os dados
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        InitRecycleView();


    }

    private fun InitRecycleView() { //acessando component recyclerView

        binding.recyclerList.layoutManager = LinearLayoutManager(this)
        binding.recyclerList.setHasFixedSize(true)    //performasse melhor na rolagem
        binding.recyclerList.adapter = MyAdapter(this, getList()) { name ->
            Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
        }

    }

    //metodo getList() recebe listof - vai ser estanciada
    private fun getList(): MutableList<String> { //lista mutavel
        return mutableListOf(
            //private fun`: A função é visível apenas dentro da classe em que está definida.
            "Debora",
            "Matheus",
            "João",
            "Debora",
            "Matheus",
            "João",
            "Debora",
            "Matheus",
            "João",
            "Debora",
            "Matheus",
            "João",
            "Debora",
            "Matheus",
            "João",
            "Debora",
            "Matheus",
            "João",
            "Debora",
            "Matheus",
            "João",
            "Debora",
            "Matheus",
            "João",


            )

    }
}

