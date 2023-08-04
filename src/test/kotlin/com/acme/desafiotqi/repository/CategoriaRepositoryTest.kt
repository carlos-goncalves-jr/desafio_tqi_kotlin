package com.acme.desafiotqi.repository

import com.acme.desafiotqi.model.Categoria
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("test")
@DataJpaTest
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
    fun categoriaRepository_ExistsByNome() {
        val existsSavedCategoria: Boolean  = categoriaRepository.existsByNome(nome = "Bebidas")

        assertThat(existsSavedCategoria).isNotNull
        assertThat(existsSavedCategoria).isTrue()
    }

    @Test
    fun categoriaRepository_FindByNome() {
        val savedCategoria: Categoria = categoriaRepository.findByNome(nome = "Peixaria")

        assertThat(savedCategoria).isNotNull()
        assertThat(savedCategoria.id).isGreaterThan(0)
        assertThat(savedCategoria.nome).isEqualTo("Peixaria")
    }

    @Test
    fun categoriaRepository_FindAll(){
        assertThat(listaDeCategorias.size).isEqualTo(4)
        assertThat(listaDeCategorias).isNotNull
    }

    @Test
    fun categoriaRepository_CheckId(){
        assertThat(categoriaRepository.findByNome("Padaria").id).isNotNull()
    }

    @Test
    fun categoriaRepository_DeleteById(){
        val savedCategoriaId: Long? = categoriaRepository.findByNome(nome = "Peixaria").id
        categoriaRepository.deleteById(savedCategoriaId!!)
        val listaCategoriasRestantes : List<Categoria> = categoriaRepository.findAll()

        assertThat(listaCategoriasRestantes.size).isEqualTo(3)
    }
}