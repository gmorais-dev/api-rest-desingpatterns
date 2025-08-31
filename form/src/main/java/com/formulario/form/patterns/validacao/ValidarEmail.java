package com.formulario.form.patterns.validacao;

import com.formulario.form.Exceptions.ValidationException;
import com.formulario.form.dto.UsuarioDto;

public class ValidarEmail implements ValidacaoStrategy {
    @Override
    public void validar(UsuarioDto dto) {
        if (dto.getEmail() == null || !dto.getEmail().contains("@")) {
            throw new ValidationException("Email inválido");
        }
    }
}
