package com.financakotlin.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.financakotlin.R
import com.financakotlin.model.Tipo
import com.financakotlin.model.Transacao
import com.financakotlin.ui.adapter.ListaTransacoesAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import java.math.BigDecimal

class ListaTransacoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val transacoes = listOf(
            Transacao(
                valor = BigDecimal(20.5),
                categoria = "comida",
                tipo = Tipo.DESPESA
            ),
            Transacao(
                valor = BigDecimal(100.0),
                tipo = Tipo.RECEITA,
                categoria = "Ecomonia"
            ),
            Transacao(
                valor = BigDecimal(20.5),
                categoria = "comida",
                tipo = Tipo.DESPESA
            ),
            Transacao(
                valor = BigDecimal(100.0),
                tipo = Tipo.RECEITA,
                categoria = "Ecomonia"
            )

        )

        lista_transacoes_listview.adapter = ListaTransacoesAdapter(transacoes, this)
    }
}
