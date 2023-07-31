package com.acme.desafiotqi.repository

import com.acme.desafiotqi.model.Categoria
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CategoriaRepositoryTest {

    @Autowired
    lateinit var categoriaRepository: CategoriaRepository

    @Test
    fun categoriaRepositoryExistsByNomeTest() {
        val categoria = Categoria(nome = "Bebidas")
        categoriaRepository.save(categoria)

        val existsSavedCategoria: Boolean  = categoriaRepository.existsByNome(categoria.nome)

        assertThat(existsSavedCategoria).isNotNull
        assertThat(existsSavedCategoria).isTrue()
    }

    @Test
    fun categoriaRepositoryFindByNomeTest() {
        val categoria = Categoria(nome = "Padaria")
        categoriaRepository.save(categoria)

        val savedCategoria: Categoria = categoriaRepository.findByNome(categoria.nome)

        assertThat(savedCategoria).isNotNull()
        assertThat(savedCategoria.id).isGreaterThan(0)
        assertThat(savedCategoria.nome).isEqualTo("Padaria")
    }

    @Test
    fun categoriaRepositoryFindAllTest(){
        val categoria  = Categoria(nome = "Padaria")
        val categoria2 = Categoria(nome = "Peixaria")
        val categoria3 = Categoria(nome = "Hortifruti")
        val categoria4 = Categoria(nome = "Hortifruti")

        val listaDeCategorias: List<Categoria> = categoriaRepository.saveAll(listOf(categoria, categoria2, categoria3, categoria4))

        assertThat(listaDeCategorias.size).isEqualTo(4)
        assertThat(listaDeCategorias).isNotNull
    }

}