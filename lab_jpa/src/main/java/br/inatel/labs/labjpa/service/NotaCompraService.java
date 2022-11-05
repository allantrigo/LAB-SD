package br.inatel.labs.labjpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.inatel.labs.labjpa.entity.NotaCompra;
import br.inatel.labs.labjpa.entity.NotaCompraItem;
import br.inatel.labs.labjpa.entity.Produto;

@Service
@Transactional
public class NotaCompraService {

	@PersistenceContext
	private EntityManager em;

	public NotaCompra salvarNotaCompra(NotaCompra nc) {
		nc = em.merge(nc);
		return nc;
	}

	public NotaCompra buscarNotaCompraPeloId(Long id) {
		NotaCompra nc = em.find(NotaCompra.class, id);
		return nc;
	}

	public List<NotaCompra> listarNotaCompra() {
		List<NotaCompra> listaNotaCompra = em.createQuery("SELECT nc FROM NotaCompra nc", NotaCompra.class).getResultList();
		return listaNotaCompra;
	}
	
	
	public NotaCompraItem salvarNotaCompraItem(NotaCompraItem nci) {
		nci = em.merge(nci);
		return nci;
	}

	public NotaCompraItem buscarNotaCompraItemPeloId(Long id) {
		NotaCompraItem nci = em.find(NotaCompraItem.class, id);
		return nci;
	}

	public List<NotaCompraItem> listarNotaCompraItem() {
		List<NotaCompraItem> listaNotaCompraItem = em.createQuery("SELECT nci FROM NotaCompraItem nci", NotaCompraItem.class).getResultList();
		return listaNotaCompraItem;
	}
}
