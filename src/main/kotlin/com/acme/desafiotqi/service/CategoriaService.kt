package com.acme.desafiotqi.service

import com.acme.desafiotqi.model.Categoria
import org.springframework.stereotype.Service

@Service
class CategoriaService {

    fun findById(id: Long?): Categoria? = Categoria(5L, "Padaria") ?: null

    fun create(categoria: Categoria): Categoria {
        val novaCategoria = Categoria(nome = categoria.nome)
        return novaCategoria
    }

    fun update(id: Long, novaCategoria: Categoria) : Categoria? {
        var categoriaAtual: Categoria? = findById(novaCategoria.id)
        categoriaAtual?.nome = novaCategoria.nome
        return categoriaAtual
    }

}