package br.inatel.labs.labjpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.inatel.labs.labjpa.entity.Produto;

@Service
@Transactional
public class ProdutoService {

	@PersistenceContext
	private EntityManager em;

	public Produto salvar(Produto p) {
		p = em.merge(p);
		return p;
	}

	public Produto buscarPeloId(Long id) {
		Produto p = em.find(Produto.class, id);
		return p;
	}

	public List<Produto> listar() {
		List<Produto> listaProduto = em.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
		return listaProduto;
	}

	public void remover(Produto p) {
		em.merge(p);
		em.remove(p);
	}
}
