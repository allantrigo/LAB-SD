package br.inatel.labs.labrest.server.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.inatel.labs.labrest.server.model.Curso;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CursoControllerTest {
	@Autowired
	private WebTestClient webTestClient;

	@Test
	void develistarCursos() {
		webTestClient.get().uri("/curso").exchange().expectStatus().isOk().expectBody().returnResult();
	}

	@Test
	void dadoIdCursoValido_quandoBuscaPorId_devolveCursoVálido() {
		Long cursoIdValido = 1l;
		Curso curso = webTestClient.get().uri("/curso/" + cursoIdValido).exchange().expectStatus().isOk()
				.expectBody(Curso.class).returnResult().getResponseBody();
		assertNotNull(curso);
		assertEquals(cursoIdValido, curso.getId());
	}

	@Test
	void dadoIdCursoInvalido_quandoBuscaPorId_devolveErroDeNaoEncontrado() {
		Long cursoIdValido = 100l;
		webTestClient.get().uri("/curso/" + cursoIdValido).exchange().expectStatus().isNotFound();
	}

	@Test
	void dadoCursoValido_quandoInsereCurso_devolveCursoCriado() {
		Curso novoCurso = new Curso();
		novoCurso.setCargaHoraria(20);
		novoCurso.setDescricao("Curso de Testes");
		Curso curso = webTestClient.post().uri("/curso").bodyValue(novoCurso).exchange().expectStatus().isCreated()
				.expectBody(Curso.class).returnResult().getResponseBody();

		assertNotNull(curso);
		assertEquals(novoCurso.getCargaHoraria(), curso.getCargaHoraria());
		assertEquals(novoCurso.getDescricao(), curso.getDescricao());
	}

	@Test
	void dadoCursoValido_quandoEditaCurso_devolveSucessoAoEditar() {
		Curso cursoASerEditado = new Curso();
		cursoASerEditado.setId(2l);
		cursoASerEditado.setDescricao("Nova Descrição");
		cursoASerEditado.setCargaHoraria(50);

		webTestClient.put().uri("/curso").bodyValue(cursoASerEditado).exchange().expectStatus().isNoContent()
				.expectBody().returnResult();
	}

	@Test
	void dadoCursoIdValido_quandoDeletaCurso_devolveSucessoAoDeletar() {
		Long cursoIdValido = 3l;
		webTestClient.delete().uri("/curso/" + cursoIdValido).exchange().expectStatus().isNoContent().expectBody()
				.returnResult();
	}
}