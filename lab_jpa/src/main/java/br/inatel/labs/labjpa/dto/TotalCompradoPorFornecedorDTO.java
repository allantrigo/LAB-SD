package br.inatel.labs.labjpa.dto;

import java.math.BigDecimal;

public class TotalCompradoPorFornecedorDTO {

	private String fornecedorRazaoSocial;
	
	private BigDecimal totalComprado;

	public TotalCompradoPorFornecedorDTO(String fRazaoSocial, BigDecimal total) {
		this.fornecedorRazaoSocial = fRazaoSocial;
		this.totalComprado = total;
	}

	public String getFornecedorRazaoSocial() {
		return fornecedorRazaoSocial;
	}

	public BigDecimal getTotalComprado() {
		return totalComprado;
	}

	@Override
	public String toString() {
		return "TotalCompradoPorFornecedorDTO [fornecedorRazaoSocial=" + fornecedorRazaoSocial + ", totalComprado="
				+ totalComprado + "]";
	}
}
