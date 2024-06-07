package com.example.exerciciospringboot.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PessoaDTO {
    private String nome;
    private String cpf;
    private String login;
    private String senha;
    private int idade;
}
