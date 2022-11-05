package br.inatel.labs.labjpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import br.inatel.labs.labjpa.dto.TotalCompradoPorFornecedorDTO;

@Service
public class RelatorioService {

	@PersistenceContext
	private EntityManager em;

	public List<TotalCompradoPorFornecedorDTO> pesquisarTotalCompradoPorFornecedor() {
		String query = " SELECT new br.inatel.labs.labjpa.dto.TotalCompradoPorFornecedorDTO " 
					 + "	( f.razaoSocial "
					 + " , SUM( i.quantidade * i.valorCompraProduto )" 
					 + " ) " 
					 + " FROM NotaCompraItem i "
					 + " JOIN i.notaCompra n " 
					 + " JOIN n.fornecedor f " 
					 + " GROUP BY f.razaoSocial ";

		return em.createQuery(query, TotalCompradoPorFornecedorDTO.class).getResultList();
	}
}
