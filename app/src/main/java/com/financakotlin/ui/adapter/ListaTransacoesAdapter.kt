package com.financakotlin.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.financakotlin.R
import com.financakotlin.model.Transacao
import kotlinx.android.synthetic.main.transacao_item.view.*
import java.text.SimpleDateFormat

class ListaTransacoesAdapter(
    transacoes: List<Transacao>,
    contexto: Context
) : BaseAdapter() {

    private val transacoes = transacoes
    private val contexto = contexto

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val viewCriada = LayoutInflater.from(contexto)
            .inflate(R.layout.transacao_item, parent, false)

        val transacao = transacoes[position]

        viewCriada.transacao_valor.text = transacao.valor.toString()
        viewCriada.transacao_categoria.text = transacao.categoria

        val formatoBrasileiro = "dd/MM/yyyy"
        val format = SimpleDateFormat(formatoBrasileiro)
        val dataFormatada = format.format(transacao.data.time)
        viewCriada.transacao_data.text = dataFormatada

        return viewCriada

    }

    override fun getItem(position: Int): Transacao {
        return transacoes[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return transacoes.size
    }
}