package com.example.exercicio_navegacaoactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val senhaPadrao = "123456"  //encapsulamento

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun Entrar(view: View) {

        val senha = findViewById<TextView>(R.id.InputSenha)
        val validacao = senha.text.toString()// conversao para tipo string

        // SE a senha tem pelo menos 6 caracteres, você pode prosseguir com o login.
        if (validacao == senhaPadrao) { // length função puxa tipo string
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Conectando ... ", Toast.LENGTH_LONG).show()

        } else {
            Toast.makeText(this, "Senha não confere", Toast.LENGTH_SHORT).show()

        }
    }
    //ciclo de vida
    override fun onPause() {
        super.onPause()
        val txt_email = findViewById<TextView>(R.id.InputEmail)
        val txt_senha = findViewById<TextView>(R.id.InputSenha)



        // Limpar dados ao sair da tela
        // Definir o texto dos campos como vazio
        txt_email.setText("")
        txt_senha.setText("")

    }
}
