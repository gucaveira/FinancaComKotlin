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
    private val transacoes: List<Transacao>,
    private val contexto: Context
) : BaseAdapter() {

    private val LIMITE_DE_CATEGORIA = 14

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val viewCriada = LayoutInflater.from(contexto)
            .inflate(R.layout.transacao_item, parent, false)

        val transacao = transacoes[position]

        adicionaValor(transacao, viewCriada)
        adicionaIcone(transacao, viewCriada)
        adicionaCategoria(viewCriada, transacao)
        adiconaData(viewCriada, transacao)

        return viewCriada
    }

    private fun adiconaData(viewCriada: View, transacao: Transacao) {
        viewCriada.transacao_data.text = transacao.data.formataParaBrasileiro()
    }

    private fun adicionaCategoria(viewCriada: View, transacao: Transacao) {
        viewCriada.transacao_categoria.text = transacao.categoria.limitaEmAte(LIMITE_DE_CATEGORIA)
    }

    private fun adicionaIcone(transacao: Transacao, viewCriada: View) {
        val icone = iconePor(transacao.tipo)
        viewCriada.transacao_icone.setBackgroundResource(icone)
    }

    private fun iconePor(tipo: Tipo): Int {
        return if (tipo == Tipo.RECEITA) {
            R.drawable.icone_transacao_item_receita
        } else {
            R.drawable.icone_transacao_item_despesa
        }
    }

    private fun adicionaValor(transacao: Transacao, viewCriada: View) {
        val cor: Int = porCor(transacao.tipo)
        viewCriada.transacao_valor.setTextColor(cor)
        viewCriada.transacao_valor.text = transacao.valor.formatadaBrasileiro()
    }

    private fun porCor(tipo: Tipo): Int {
        return when(tipo){
            Tipo.RECEITA -> ContextCompat.getColor(contexto, R.color.receita)
            else ->ContextCompat.getColor(contexto, R.color.despesa)
        }
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