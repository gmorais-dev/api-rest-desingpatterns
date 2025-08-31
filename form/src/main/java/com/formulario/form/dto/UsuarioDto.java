package com.formulario.form.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

//Factory/Builder Pattern criar os objetos e instanciar de forma organizada a partir do dto
//DTO Pattern: transporte de dados entre Controller e Service
@Data
@NoArgsConstructor
public class UsuarioDto {
    private String nome;
    private Integer idade;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;

}

