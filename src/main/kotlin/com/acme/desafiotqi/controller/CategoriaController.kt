package com.acme.desafiotqi.controller

import com.acme.desafiotqi.model.Categoria
import com.acme.desafiotqi.service.CategoriaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class CategoriaController {

    @Autowired
    lateinit var categoriaService: CategoriaService

    @GetMapping("/categorias")
    fun show(): ResponseEntity<List<Categoria>> = ResponseEntity.ok(categoriaService.findAll())

    @GetMapping("/categorias/{id}")
    fun findById(@PathVariable id: Long) : ResponseEntity<Categoria> = ResponseEntity.ok(categoriaService.findById(id))

    @GetMapping("/categorias/nome/{nome}")
    fun findByNome(@PathVariable nome: String) : ResponseEntity<Categoria> = ResponseEntity.ok(categoriaService.findByNome(nome))

    @PutMapping("/categorias/{id}")
    fun update(@PathVariable id: Long, @RequestBody novaCategoria: Categoria) : ResponseEntity<Categoria> {
        return ResponseEntity.ok(categoriaService.update(id, novaCategoria))
    }

    @PostMapping("/categorias")
    fun create(@RequestBody categoria: Categoria): ResponseEntity<Categoria>  = ResponseEntity(categoriaService.create(categoria), HttpStatus.CREATED)

    @DeleteMapping("/categorias/{id}")
    fun delete(@PathVariable id : Long): ResponseEntity<HttpStatus> {
        categoriaService.deleteById(id)
        return ResponseEntity.ok(HttpStatus.NO_CONTENT)
    }

}