package com.example.exerciciospringboot.controller;

import com.example.exerciciospringboot.dto.PessoaDTO;
import com.example.exerciciospringboot.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    private final PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody PessoaDTO pessoaDTO){
        pessoaService.save(pessoaDTO);
        return new ResponseEntity<>(
                "inserido com sucesso!",
                HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> findAll(){
        return new ResponseEntity<>( pessoaService.findAll(), HttpStatus.OK);
    };

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>( pessoaService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        pessoaService.deleteById(id);
        return new ResponseEntity<>( "Deletado com sucesso", HttpStatus.OK);
    }
}
