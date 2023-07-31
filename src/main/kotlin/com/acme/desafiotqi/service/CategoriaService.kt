package com.acme.desafiotqi.service

import com.acme.desafiotqi.model.Categoria
import com.acme.desafiotqi.repository.CategoriaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CategoriaService {

    @Autowired
    lateinit var categoriaRepository : CategoriaRepository

    fun findById(id: Long): Categoria? {
        var temp = categoriaRepository.findById(id)
        return temp.get()
    }

    fun create(categoria: Categoria): Categoria {
        return categoriaRepository.save(Categoria(nome = categoria.nome))
    }

    fun update(id: Long, novaCategoria: Categoria) : Categoria? {
//        var categoriaAtual: Categoria? = findById(novaCategoria.id)
//        categoriaAtual?.nome = novaCategoria.nome
        return null
    }

}