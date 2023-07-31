package com.acme.desafiotqi.repository

import com.acme.desafiotqi.model.Categoria
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoriaRepository : JpaRepository<Categoria, Long> {
    fun existsByNome(nome: String) : Boolean

    fun findByNome(nome: String) : Categoria

}