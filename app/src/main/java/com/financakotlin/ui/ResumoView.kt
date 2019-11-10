package com.financakotlin.ui

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import com.financakotlin.R
import com.financakotlin.extension.formatadaBrasileiro
import com.financakotlin.model.Resumo
import com.financakotlin.model.Transacao
import kotlinx.android.synthetic.main.resumo_card.view.*
import java.math.BigDecimal

class ResumoView(
    private val contexto: Context,
    private val view: View,
    transacoes: List<Transacao>
) {
    private val resumo: Resumo = Resumo(transacoes)

    private val corReceita = ContextCompat.getColor(contexto, R.color.receita)
    private val corDespesa = ContextCompat.getColor(contexto, R.color.despesa)

    fun adicionaReceita() {
        val totalReceita = resumo.receita()
        with(view.resumo_card_receita) {
            setTextColor(corReceita)
            text = totalReceita.formatadaBrasileiro()
        }
    }

    fun adicionaDespesa() {
        val totalDespesa = resumo.despesa()
        with(view.resumo_card_despesa) {
            setTextColor(corDespesa)
            text = totalDespesa.formatadaBrasileiro()
        }
    }

    fun adicionaTotal() {
        val total = resumo.total()
        val cor = corPor(total)
        with(view.resumo_card_total) {
            setTextColor(cor)
            text = total.formatadaBrasileiro()
        }
    }

    private fun corPor(valor: BigDecimal): Int {
        return if (valor >= BigDecimal.ZERO) {
            corReceita
        } else {
            corDespesa
        }
    }
}