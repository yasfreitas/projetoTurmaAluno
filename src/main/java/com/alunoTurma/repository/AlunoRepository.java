package com.alunoTurma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alunoTurma.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}
