package com.financakotlin.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.financakotlin.R

class ListaTransacoesAdapter(transacoes: List<String>,
                             contexto: Context) : BaseAdapter() {

    private val transacoes = transacoes
    private val contexto = contexto

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return LayoutInflater.from(contexto).inflate(R.layout.transacao_item, parent, false)
    }

    override fun getItem(position: Int): String {
        return transacoes[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
    return transacoes.size
    }
}