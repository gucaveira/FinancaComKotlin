package com.financakotlin.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.financakotlin.R
import com.financakotlin.model.Tipo
import com.financakotlin.model.Transacao
import com.financakotlin.ui.ResumoView
import com.financakotlin.ui.adapter.ListaTransacoesAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import java.math.BigDecimal

class ListaTransacoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val transacoes: List<Transacao> = transacoesDeExemplo()

        configuraResumo(transacoes)

        configuraLista(transacoes)
    }

    private fun configuraResumo(transacoes: List<Transacao>) {
        val view = window.decorView
        val resumoView = ResumoView(contexto = this, view = view, transacoes = transacoes)
        resumoView.adicionaDespesa()
        resumoView.adicionaReceita()
        resumoView.adicionaTotal()
    }

    private fun configuraLista(transacoes: List<Transacao>) {
        lista_transacoes_listview.adapter = ListaTransacoesAdapter(transacoes, this)
    }

    private fun transacoesDeExemplo(): List<Transacao> {
        return listOf(
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
    }
}
