package com.example.exerciciospringboot.repository;

import com.example.exerciciospringboot.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
