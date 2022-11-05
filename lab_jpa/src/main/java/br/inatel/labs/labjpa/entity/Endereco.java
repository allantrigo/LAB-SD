package br.inatel.labs.labjpa.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Endereco {

	@Id
	private String codigo;

	@NotNull
	private String rua;

	@NotNull
	private String numero;

	private String complemento;

	private String bairro;

	@NotNull
	private String cidade;

	@NotNull
	@Size(max = 2)
	private String uf;

	@PrePersist
	private void preencherCodigo() {
		this.codigo = UUID.randomUUID().toString();
	}
	
	
}
