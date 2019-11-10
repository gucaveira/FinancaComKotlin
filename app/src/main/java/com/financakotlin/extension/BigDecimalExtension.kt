package com.financakotlin.extension

import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.Locale

fun BigDecimal.formatadaBrasileiro(): String {
    val formatadaBrasileiro = DecimalFormat
        .getCurrencyInstance(Locale("pt", "br"))
   return formatadaBrasileiro
        .format(this).replace("-R$", "R$ -")
}