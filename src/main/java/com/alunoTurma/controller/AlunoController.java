package com.alunoTurma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alunoTurma.entities.Aluno;
import com.alunoTurma.service.AlunoService;

import jakarta.validation.Valid;

@RestController 
@CrossOrigin(origins= "*") 
@RequestMapping("/aluno") 
public class AlunoController {

	private final AlunoService alunoService; 
	
	@Autowired  
	public AlunoController(AlunoService alunoService) {  
		this.alunoService = alunoService;  
	}  
	
	@GetMapping("/{id}")  
	public ResponseEntity<Aluno> buscaAlunoControlId(@PathVariable Long id){  
		Aluno aluno = alunoService.buscaAlunoId(id);  
		if(aluno != null) {  
			return ResponseEntity.ok(aluno);  
		}  
		else {  
			return ResponseEntity.notFound().build();  
		}  
	} 
	@GetMapping("/cidade/{cidade}")
	public ResponseEntity<List<Aluno>> buscarAlunoPorCidade(@PathVariable String cidade){
		List<Aluno> alunos = alunoService.buscarAlunoPorCidade(cidade);
		return ResponseEntity.ok(alunos);
	}
	@GetMapping("/renda/{renda}")
	public ResponseEntity<List<Aluno>> buscarAlunoPorRenda(@PathVariable double renda){
		List<Aluno> alunos = alunoService.buscarAlunoPorRenda(renda);
		return ResponseEntity.ok(alunos);
	}
	@GetMapping("/ra/{ra}")
	public ResponseEntity<List<Aluno>> buscarAlunoPorRa(@PathVariable String ra){
		List<Aluno> alunos = alunoService.buscarAlunoPorRa(ra);
		return ResponseEntity.ok(alunos);
	}
	@GetMapping("/cidade/{cidade}/renda/{renda}")
	public ResponseEntity<List<Aluno>> buscarAlunoPorCidadeERenda(@PathVariable String cidade, @PathVariable double renda ){
		List<Aluno> alunos = alunoService.buscarAlunoPorCidadeERenda(cidade, renda);
		return ResponseEntity.ok(alunos);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Aluno>> buscaTodosAlunosControl(){  
		List<Aluno>Aluno = alunoService.buscaTodosAlunos();  
		return ResponseEntity.ok(Aluno);  
	}  
	
	@PostMapping  
	public ResponseEntity<Aluno> salvaAlunosControl(@RequestBody @Valid Aluno aluno){  
		Aluno salvaAluno = alunoService.salvaAluno(aluno);  
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaAluno);  
	}  
	
	@PutMapping("/{id}")  
	public ResponseEntity<Aluno> alteraAlunoControl(@PathVariable Long id, @RequestBody @Valid Aluno aluno){ 
		Aluno alteraAluno = alunoService.alterarAluno(id, aluno);  
		if(alteraAluno != null) {  
			return ResponseEntity.ok(aluno);  
		}  
		else {  
			return ResponseEntity.notFound().build();  
	}  

	}  
	
	@DeleteMapping("/{id}")  
	public ResponseEntity<Aluno> apagaAlunoControl(@PathVariable Long id){  
		boolean apagar = alunoService.apagarAluno(id);  
		if (apagar) {  
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  
		}  
		else {  
			return ResponseEntity.notFound().build(); 
		}  
	} 

}
