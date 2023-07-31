package com.acme.desafiotqi.service

import com.acme.desafiotqi.model.Categoria
import com.acme.desafiotqi.repository.CategoriaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CategoriaService {

    @Autowired
    lateinit var categoriaRepository : CategoriaRepository

    fun isCategoriaExistent(nome: String) : Boolean = categoriaRepository.existsByNome(nome)

    fun findById(id: Long): Categoria = categoriaRepository.findById(id).get()

    fun findAll() : List<Categoria> = categoriaRepository.findAll()

    fun deleteById(id: Long) = categoriaRepository.deleteById(id)

    fun create(categoria: Categoria): Categoria {
        return when(isCategoriaExistent(categoria.nome)) {
           true -> categoriaRepository.findByNome(categoria.nome)
           false -> categoriaRepository.save(Categoria(nome = categoria.nome))
        }
    }

    fun update(id: Long, novaCategoria: Categoria) : Categoria {
        val categoriaAtual = findById(id)
        when(isCategoriaExistent(novaCategoria.nome)) {
            true -> throw IllegalArgumentException("Nome já cadastrado")
            false -> categoriaAtual.nome = novaCategoria.nome
        }
        return categoriaRepository.save(categoriaAtual)
    }

}