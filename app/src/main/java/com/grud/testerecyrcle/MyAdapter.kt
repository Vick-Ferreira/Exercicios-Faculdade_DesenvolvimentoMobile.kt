package com.grud.testerecyrcle

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(
    private  val context: Context,
    private val MinhaLista: MutableList<String>,
    val itemClicado: (String) -> Unit,

) : RecyclerView.Adapter<MyAdapter.MyView>(){


    //RESPONSAVEL POR CRIAR O LAYOUT POR CADA LINHA QUE TEMOSS
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.fragment_item,parent,false)
        return MyView(itemView)

    }
    //IMPRIME AS INFORMAÇÕES

    override  fun onBindViewHolder(holder: MyView, position: Int) {
        val name = MinhaLista[position]  //variavel name pega lista e suas posições
        holder.txtName.text = name
        //evento click
        //itemView pois quero pegar a área toda, se fosse em cima apenas do nome seria referência apenas do nome.  -ex:txtName

        holder.itemView.setOnClickListener {itemClicado(name)} //ao clicar na a´rea total do item o name vai aparecer

        // Configurar o clique no botão "Editar"
        holder.buttonEdit.setOnClickListener {
            showEditDialog(name, position)
        }
    }


    //RETORNA O TAMANHO DA FONTE DE DADOS, PARA SABER VALOR D ELINHAS
    override fun getItemCount() = MinhaLista.size

    inner class MyView(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtName: TextView = itemView.findViewById(R.id.itemNome)
        val buttonEdit: Button = itemView.findViewById(R.id.buttonEdit)
    }
    private fun showEditDialog(name: String, position: Int) {
        val dialogBuilder = AlertDialog.Builder(context)
        dialogBuilder.setTitle("Editar Nome")

        val editText = EditText(context)
        editText.setText(name)
        dialogBuilder.setView(editText)


            .setPositiveButton("Salvar") { _, _ ->
                // Atualize o item com o novo valor
                MinhaLista[position] = editText.text.toString()
                notifyItemChanged(position)
            }
            .setNegativeButton("Cancelar") { dialog, _ ->
                dialog.dismiss()
            }

        val alertDialog = dialogBuilder.create()
        alertDialog.show()
    }
}