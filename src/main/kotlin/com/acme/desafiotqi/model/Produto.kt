package com.acme.desafiotqi.model

import com.acme.desafiotqi.enum.UnidadeDeMedida
import jakarta.persistence.*

@Entity
@Table(name = "tbl_produto")
data class Produto(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long? = null,
    val nome : String,
    val unidadeDeMedida : UnidadeDeMedida,
    var precoUnitario : Double,
)


