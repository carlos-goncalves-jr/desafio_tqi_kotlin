package com.acme.desafiotqi.service

import com.acme.desafiotqi.model.Produto
import com.acme.desafiotqi.repository.ProdutoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProdutoService {

    @Autowired
    lateinit var produtoRepository : ProdutoRepository

    fun findById(id: Long): Produto = produtoRepository.findById(id).get()
    fun findAll(): List<Produto> = produtoRepository.findAll()
    fun findByNome(nome: String): Produto? = produtoRepository.findByNome(nome)

    fun isProdutoExistent(nome : String) : Boolean = produtoRepository.existsByNome(nome)
    fun create(produto: Produto): Produto {
        return when (isProdutoExistent(produto.nome)) {
            true -> produtoRepository.findByNome(produto.nome)
            false -> produtoRepository.save(
                Produto(nome = produto.nome,
                    precoUnitario = produto.precoUnitario,
                    unidadeDeMedida = produto.unidadeDeMedida))
        }
    }


}