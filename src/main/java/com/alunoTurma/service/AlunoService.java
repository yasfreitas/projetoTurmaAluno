package com.alunoTurma.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alunoTurma.entities.Aluno;
import com.alunoTurma.repository.AlunoRepository;

@Service
public class AlunoService {
	
	private final AlunoRepository alunoRepository;     
	@Autowired     
	public AlunoService(AlunoRepository alunoRepository) {     
		this.alunoRepository = alunoRepository;     
	}    
	public List<Aluno> buscaTodosAlunos() {     
		return alunoRepository.findAll();    
	}    
	public Aluno buscaAlunoId(Long id) {     
		Optional <Aluno> aluno = alunoRepository.findById(id);    
		return aluno.orElse(null);    
	}    
	public List<Aluno> buscarAlunosPorCidade(String cidade){
		return alunoRepository.findByCidade(cidade);
	}
	public List<Aluno> buscarAlunosPorRenda(double renda){
		return alunoRepository.findByRenda(renda);
	}
	public List<Aluno> buscarAlunosPorRa(String ra){
		return alunoRepository.findByra(ra);
	}
	public List<Aluno> buscarAlunosPorCidadeRenda(String cidade, double renda){
		return alunoRepository.findByCidadeAndRenda(cidade, renda);
	}
	public List<Aluno> findByNome(String nome){
		return alunoRepository.findByNome(nome);
	}
	public List<Aluno> findByNomeCompletoLike(String nomeCompleto){
		return alunoRepository.findByNomeLike(nomeCompleto);
	}
	public Aluno salvaAluno(Aluno aluno) {     
		return alunoRepository.save(aluno);     
	}
	public List<Aluno> findByTurmaId(Long turmaId){
		return alunoRepository.findByTurmaId(turmaId);
	}
	public Aluno alterarAluno(Long id, Aluno alterarUser) {     
		Optional <Aluno> existeAluno = alunoRepository.findById(id);     
		if (existeAluno.isPresent()) {     
			alterarUser.setId(id);     
			return alunoRepository.save(alterarUser);     
		}    
		return null;     
	}    
	public boolean apagarAluno(Long id) {    
		Optional <Aluno> existeAluno = alunoRepository.findById(id);     
		if (existeAluno.isPresent()) {     
			alunoRepository.deleteById(id);     
			return true;     
		}    
		return false;     
	}   
}
