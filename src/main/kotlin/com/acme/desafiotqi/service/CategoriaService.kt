package com.acme.desafiotqi.service

import com.acme.desafiotqi.model.Categoria
import com.acme.desafiotqi.repository.CategoriaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CategoriaService {

    @Autowired
    lateinit var categoriaRepository : CategoriaRepository

    fun findById(id: Long): Categoria = categoriaRepository.findById(id).get() ?: throw IllegalArgumentException("Id não existente")

    fun create(categoria: Categoria): Categoria {
        return when(isCategoriaExistent(categoria.nome)) {
           true -> categoriaRepository.findByNome(categoria.nome)
           false -> categoriaRepository.save(Categoria(nome = categoria.nome))
        }
    }

    fun update(id: Long, novaCategoria: Categoria) : Categoria {
        var categoriaAtual = findById(id)
        when(isCategoriaExistent(novaCategoria.nome)) {
            true -> throw IllegalArgumentException("Nome já cadastrado")
            false -> categoriaAtual.nome = novaCategoria.nome
        }
        return categoriaRepository.save(categoriaAtual)
    }

    fun isCategoriaExistent(nome: String) : Boolean = categoriaRepository.existsByNome(nome)



}