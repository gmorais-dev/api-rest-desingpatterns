package com.formulario.form.mapper;

import com.formulario.form.dto.UsuarioDto;
import com.formulario.form.entity.Usuario;
//aqui esta a classe que converte de dto > entidade
public class UsuarioMapper {

    public static UsuarioDto toDto(Usuario usuario) {
        UsuarioDto dto = new UsuarioDto();
        dto.setNome(usuario.getNome());
        dto.setIdade(usuario.getIdade());
        dto.setCpf(usuario.getCpf());
        dto.setDataNascimento(usuario.getDataNascimento());
        dto.setEmail(usuario.getEmail());
        return dto;
    }
}

