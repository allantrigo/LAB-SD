package br.inatel.labs.labrest.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.inatel.labs.labrest.server.model.Curso;

@Service
public class CursoService {

	private List<Curso> listaDeCursos = new ArrayList<>();

	public List<Curso> pesquisarCurso() {
		return listaDeCursos;
	}
}
