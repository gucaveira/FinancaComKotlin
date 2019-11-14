package com.financakotlin.model

import java.math.BigDecimal

class Resumo(private val transacoes: List<Transacao>) {

    val receita get() = somarPor(Tipo.RECEITA)

    fun despesa() = somarPor(Tipo.DESPESA)

    private fun somarPor(tipo: Tipo): BigDecimal {
        return BigDecimal(transacoes.filter { it.tipo == tipo }
            .sumByDouble { it.valor.toDouble() })
    }

    fun total() = receita.subtract(despesa())
}