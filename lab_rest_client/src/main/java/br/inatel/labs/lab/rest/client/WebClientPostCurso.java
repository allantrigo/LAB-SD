package br.inatel.labs.lab.rest.client;

import org.springframework.web.reactive.function.client.WebClient;
import br.inatel.labs.lab.rest.client.model.Curso;

public class WebClientPostCurso {
	public static void main(String[] args) {
		Curso novoCurso = new Curso();
		novoCurso.setDescricao("Dominando Spring WebFlux");
		novoCurso.setCargaHoraria(80);
		Curso cursoCriado = WebClient.create("http://localhost:8080").post().uri("/curso").bodyValue(novoCurso)
				.retrieve().bodyToMono(Curso.class).block();
		System.out.println("Curso criado: ");
		System.out.println(cursoCriado); 
	}
}