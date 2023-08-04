package com.acme.desafiotqi.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table(name = "tbl_categoria")
data class Categoria (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var nome: String = "empty",

    @OneToMany(mappedBy = "categoria")
    @JsonIgnore
    var produtos : List<Produto> = mutableListOf()
    )
