package com.formulario.form.entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.Builder;
import java.time.LocalDate;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "usuarios", uniqueConstraints = {
        @UniqueConstraint(columnNames = "cpf"),
        @UniqueConstraint(columnNames = "email")
})

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer idade;

    @Column(nullable = false, unique = true)
    private String cpf;

    private LocalDate dataNascimento;

    @Column(nullable = false, unique = true)
    private String email;

    @Builder
    public Usuario(Long id, String nome, Integer idade, String cpf, LocalDate dataNascimento, String email) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
    }
}