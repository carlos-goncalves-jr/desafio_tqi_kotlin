package com.acme.desafiotqi.controller

import com.acme.desafiotqi.model.Categoria
import com.acme.desafiotqi.service.CategoriaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class CategoriaController {

    @Autowired
    lateinit var categoriaService: CategoriaService

    @GetMapping("/categorias")
    fun show(): ResponseEntity<Categoria> = ResponseEntity.ok(Categoria(10, "Carnes"))

    @GetMapping("/categorias/{id}")
    fun findById(@PathVariable id: Long) : ResponseEntity<Categoria> {
        return ResponseEntity.ok(categoriaService.findById(id))
    }

    @PutMapping("/categorias/{id}")
    fun update(@PathVariable id: Long, @RequestBody novaCategoria: Categoria) : ResponseEntity<Categoria> {
        return ResponseEntity.ok(categoriaService.update(id, novaCategoria))
    }

    @PostMapping("/categorias/cadastro")
    fun create(@RequestBody categoria: Categoria): ResponseEntity<Categoria>  = ResponseEntity.ok(categoriaService.create(categoria))

}