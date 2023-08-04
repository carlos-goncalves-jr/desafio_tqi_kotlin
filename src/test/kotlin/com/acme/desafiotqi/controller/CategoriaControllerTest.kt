package com.acme.desafiotqi.controller

import com.acme.desafiotqi.model.Categoria
import com.acme.desafiotqi.service.CategoriaService
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(controllers = [CategoriaController::class])
class CategoriaControllerTest {

    @Autowired
    lateinit var mockMvc : MockMvc

    @Autowired
    lateinit var objectMapper : ObjectMapper

    @MockBean
    lateinit var categoriaService: CategoriaService

    @Test
    fun categoriaController_Create() {
        val novaCategoria : Categoria = Categoria(666L, "BEBIDAS")
        mockMvc.perform(post("/categorias")
            .contentType("application/json")
            .content(objectMapper.writeValueAsString(novaCategoria)))
            .andExpect(status().isCreated)
    }

    @Test
    fun categoriaController_GetById() {
        val novaCategoria : Categoria = Categoria(666L, "ALIMENTOS")
        mockMvc.perform(get("/categorias/{id}",666L)
            .contentType("application/json"))
            .andExpect(status().isOk)
    }

}