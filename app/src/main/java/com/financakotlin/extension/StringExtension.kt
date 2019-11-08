package com.financakotlin.extension


fun String.limitaEmAte(caracteres: Int): String {
    val primeiroCaractere = 0
    if (this.length > caracteres) {
        return "${this.substring(primeiroCaractere, caracteres)}..."
    }
    return this
}