package com.acme.desafiotqi.controller

import com.acme.desafiotqi.model.Produto
import com.acme.desafiotqi.service.ProdutoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ProdutoController {

    @Autowired
    lateinit var produtoService : ProdutoService

    @GetMapping("/produtos/{id}")
    fun findById(@PathVariable id : Long) : ResponseEntity<Produto> =  ResponseEntity.ok(produtoService.findById(id))

    @GetMapping("/produtos")
    fun findAll() : ResponseEntity<List<Produto>> = ResponseEntity.ok(produtoService.findAll())

    @GetMapping("/produtos/nome/{nome}")
    fun findByNome(@PathVariable nome : String) : ResponseEntity<Produto> = ResponseEntity.ok(produtoService.findByNome(nome))

    @PostMapping("/produtos")
    fun create(@RequestBody produto: Produto): ResponseEntity<Produto> = ResponseEntity(produtoService.create(produto), HttpStatus.CREATED)

}