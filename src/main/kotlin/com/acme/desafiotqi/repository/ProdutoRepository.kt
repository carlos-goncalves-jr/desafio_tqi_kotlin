package com.acme.desafiotqi.repository

import com.acme.desafiotqi.model.Produto
import org.springframework.data.jpa.repository.JpaRepository

interface ProdutoRepository : JpaRepository<Produto, Long> {
    fun findByNome(nome: String): Produto
    fun existsByNome(nome: String): Boolean

}