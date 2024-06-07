package com.example.exerciciospringboot.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pessoa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nome;
    private String cpf;
    private String login;
    private String senha;
    private int idade;
}
