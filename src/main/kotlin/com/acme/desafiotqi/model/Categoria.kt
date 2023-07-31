package com.acme.desafiotqi.model

import jakarta.persistence.*

@Entity
@Table(name = "tbl_categoria")
data class Categoria (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var nome: String
)
