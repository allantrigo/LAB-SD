package br.inatel.labs.lab.rest.client;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import br.inatel.labs.lab.rest.client.model.Curso;
import reactor.core.publisher.Mono;

public class WebClientGetCursoId {
	public static void main(String[] args) {
		try {
			Mono<Curso> monoCurso = WebClient.create("http://localhost:8080").get().uri("/curso/2").retrieve()
					.bodyToMono(Curso.class);

			monoCurso.subscribe();

			Curso curso = monoCurso.block();

			System.out.println("Curso encontrado: ");
			System.out.println(curso);
		} catch (WebClientResponseException e) {
			System.out.println("Status code: " + e.getStatusCode());
		}
	}
}