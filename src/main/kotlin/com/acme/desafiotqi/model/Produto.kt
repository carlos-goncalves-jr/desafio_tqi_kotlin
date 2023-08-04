package com.acme.desafiotqi.model

import com.acme.desafiotqi.enum.UnidadeDeMedida
import jakarta.persistence.*

@Entity
@Table(name = "tbl_produto")
data class Produto(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long? = null,
    var nome : String,
    @Enumerated(EnumType.STRING)
    var unidadeDeMedida : UnidadeDeMedida,
    var precoUnitario : Double,
)


