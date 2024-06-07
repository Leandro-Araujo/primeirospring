package com.example.exerciciospringboot.service;

import com.example.exerciciospringboot.dto.PessoaDTO;
import com.example.exerciciospringboot.model.Pessoa;
import com.example.exerciciospringboot.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public void save(PessoaDTO pessoaDTO){
        Pessoa pessoa = Pessoa.builder()
                .nome(pessoaDTO.getNome())
                .cpf(pessoaDTO.getCpf())
                .idade(pessoaDTO.getIdade())
                .login(pessoaDTO.getLogin())
                .senha(pessoaDTO.getSenha())
                .build();
        pessoaRepository.save(pessoa);
    }
    public List<PessoaDTO> findAll(){
        List<Pessoa> pessoas = pessoaRepository.findAll();
        List<PessoaDTO> pessoaDTOS = pessoas.stream().map(pessoa -> {
            return PessoaDTO.builder()
                    .nome(pessoa.getNome())
                    .cpf(pessoa.getCpf())
                    .idade(pessoa.getIdade())
                    .login(pessoa.getLogin())
                    .senha(pessoa.getSenha())
                    .build();
        }).toList();
        return pessoaDTOS;
    }
    public PessoaDTO findById(Long id) throws NullPointerException{
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);

        if (pessoa.isPresent()){
            return PessoaDTO.builder()
                    .nome(pessoa.get().getNome())
                    .cpf(pessoa.get().getCpf())
                    .idade(pessoa.get().getIdade())
                    .login(pessoa.get().getLogin())
                    .senha(pessoa.get().getSenha())
                    .build();
        }
        return null;
    }
    public void deleteById(Long id){
        pessoaRepository.deleteById(id);
    }
}
