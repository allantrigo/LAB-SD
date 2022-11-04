package br.inatel.labs.lab.rest.client;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import br.inatel.labs.lab.rest.client.model.Curso;
import reactor.core.publisher.Mono;

public class WebClientDeleteCurso {
	public static void main(String[] args) {
		ResponseEntity<Void> responseEntity = WebClient.create("http://localhost:8080")
				.delete()
				.uri("/curso/8098811426963896412")
				.retrieve().toBodilessEntity().block();
		HttpStatus statusCode = responseEntity.getStatusCode();
		System.out.println("Curso removido. Status da resposta: " + statusCode);
	}
}