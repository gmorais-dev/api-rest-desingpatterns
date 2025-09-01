package com.formulario.form.patterns.validacao;
import com.formulario.form.dto.UsuarioDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
@RequiredArgsConstructor
public class UsuarioValidator {

    private final List<ValidacaoStrategy> estrategias;

    public void validar(UsuarioDto dto) {
        estrategias.forEach(e -> e.validar(dto));
    }
}
