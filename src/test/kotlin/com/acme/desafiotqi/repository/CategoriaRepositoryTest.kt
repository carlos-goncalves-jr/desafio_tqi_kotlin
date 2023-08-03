package com.acme.desafiotqi.repository

import com.acme.desafiotqi.model.Categoria
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CategoriaRepositoryTest {

    @Autowired
    lateinit var categoriaRepository: CategoriaRepository
    lateinit var categoria : Categoria
    lateinit var categoria2 : Categoria
    lateinit var categoria3 : Categoria
    lateinit var categoria4 : Categoria
    lateinit var listaDeCategorias: List<Categoria>

    @BeforeAll
    fun setUpTests(){
        categoria = Categoria(nome = "Bebidas")
        categoria2 = Categoria(nome = "Peixaria")
        categoria3 = Categoria(nome = "Hortifruti")
        categoria4 = Categoria(nome = "Padaria")
        listaDeCategorias = categoriaRepository.saveAll(listOf(categoria, categoria2, categoria3, categoria4))
    }

    @Test
    fun categoriaRepositoryExistsByNomeTest() {
        val existsSavedCategoria: Boolean  = categoriaRepository.existsByNome(nome = "Bebidas")

        assertThat(existsSavedCategoria).isNotNull
        assertThat(existsSavedCategoria).isTrue()
    }

    @Test
    fun categoriaRepositoryFindByNomeTest() {
        val savedCategoria: Categoria = categoriaRepository.findByNome(nome = "Peixaria")

        assertThat(savedCategoria).isNotNull()
        assertThat(savedCategoria.id).isGreaterThan(0)
        assertThat(savedCategoria.nome).isEqualTo("Peixaria")
    }

    @Test
    fun categoriaRepositoryFindAllTest(){
        assertThat(listaDeCategorias.size).isEqualTo(4)
        assertThat(listaDeCategorias).isNotNull
    }

    @Test
    fun categoriaRepositoryCheckId(){
        assertThat(categoriaRepository.findByNome("Padaria").id).isNotNull()
    }

}