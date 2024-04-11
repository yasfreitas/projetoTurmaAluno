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
	
	public List<Aluno> buscaTodosAlunos(){ 
		return alunoRepository.findAll(); 
	} 
	
	public Aluno buscaAlunoId(Long id) { 
		Optional <Aluno> Aluno = alunoRepository.findById(id); 
		return Aluno.orElse(null); 
	} 
	public List<Aluno> buscarAlunoPorCidade(String cidade){
		return alunoRepository.findByCidade(cidade);
	}
	public List<Aluno> buscarAlunoPorRenda(double renda){
		return alunoRepository.findByRenda(renda);
	}
	public List<Aluno> buscarAlunoPorRa(String ra){
		return alunoRepository.findByRa(ra);
	}
	public List<Aluno> buscarAlunoPorCidadeERenda(String cidade, double renda){
		return alunoRepository.findByCidadeAndRenda(cidade, renda);
	}
	
	public Aluno salvaAluno(Aluno aluno) { 
		return alunoRepository.save(aluno); 
	} 
	
	public Aluno alterarAluno( Long id, Aluno alterarAluno) { 
		Optional<Aluno> existeAluno = alunoRepository.findById(id); 
		if(existeAluno.isPresent()) { 
			alterarAluno.setId(id); 
			return alunoRepository.save(alterarAluno); 
		} 
		return null; 
	} 
	
	public boolean apagarAluno(Long id) { 
		Optional<Aluno> existeAluno = alunoRepository.findById(id); 
		if(existeAluno.isPresent()) { 
			alunoRepository.deleteById(id); 
			return true; 
		} 
		return false; 
	} 
}
