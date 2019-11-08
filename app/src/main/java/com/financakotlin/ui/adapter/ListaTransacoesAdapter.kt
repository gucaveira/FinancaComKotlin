package com.financakotlin.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.content.ContextCompat
import com.financakotlin.R
import com.financakotlin.extension.formataParaBrasileiro
import com.financakotlin.extension.formatadaBrasileiro
import com.financakotlin.extension.limitaEmAte
import com.financakotlin.model.Tipo
import com.financakotlin.model.Transacao
import kotlinx.android.synthetic.main.transacao_item.view.*

class ListaTransacoesAdapter(
    transacoes: List<Transacao>,
    contexto: Context
) : BaseAdapter() {

    private val transacoes = transacoes
    private val contexto = contexto

    private val limiteDaCategoria = 14

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val viewCriada = LayoutInflater.from(contexto)
            .inflate(R.layout.transacao_item, parent, false)

        val transacao = transacoes[position]

        if (transacao.tipo == Tipo.RECEITA) {
            viewCriada.transacao_valor
                .setTextColor(ContextCompat.getColor(contexto, R.color.receita))
        } else {
            viewCriada.transacao_valor
                .setTextColor(ContextCompat.getColor(contexto, R.color.despesa))
        }
        if (transacao.tipo == Tipo.RECEITA) {
            viewCriada.transacao_icone.setBackgroundResource(R.drawable.icone_transacao_item_receita)
        } else {
            viewCriada.transacao_icone.setBackgroundResource(R.drawable.icone_transacao_item_despesa)
        }



        viewCriada.transacao_valor.text = transacao.valor.formatadaBrasileiro()
        viewCriada.transacao_categoria.text = transacao.categoria.limitaEmAte(limiteDaCategoria)
        viewCriada.transacao_data.text = transacao.data.formataParaBrasileiro()

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