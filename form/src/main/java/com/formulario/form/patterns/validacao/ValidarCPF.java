package com.formulario.form.patterns.validacao;

import com.formulario.form.Exceptions.ValidationException;
import com.formulario.form.dto.UsuarioDto;
import org.springframework.stereotype.Component;


@Component
public class ValidarCPF implements ValidacaoStrategy {
    @Override
    public void validar(UsuarioDto dto) {
        String cpf = dto.getCpf();
        if (cpf == null || cpf.isBlank()) {
            throw new ValidationException("CPF inválido: vazio");
        }
        if (cpf.length() != 11) {
            throw new ValidationException("CPF inválido: deve ter exatamente 11 dígitos");
        }


    }

    }

