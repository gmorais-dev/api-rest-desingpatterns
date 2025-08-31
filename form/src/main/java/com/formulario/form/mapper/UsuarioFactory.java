package com.formulario.form.mapper;

import com.formulario.form.dto.UsuarioDto;
import com.formulario.form.entity.Usuario;

//Factory → cria o objeto com regras, garante consistência.
//todas as criações de Usuario passam por um ponto central.
public class UsuarioFactory {

    public static Usuario criarUsuario(UsuarioDto dto) {
        return Usuario.builder()
                .nome(dto.getNome())
                .idade(dto.getIdade())
                .cpf(dto.getCpf())
                .dataNascimento(dto.getDataNascimento())
                .email(dto.getEmail())
                .build();
    }
}
