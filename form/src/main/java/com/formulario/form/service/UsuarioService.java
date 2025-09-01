package com.formulario.form.service;

import com.formulario.form.Exceptions.DuplicateResourceException;
import com.formulario.form.Exceptions.ValidationException;
import com.formulario.form.dto.UsuarioDto;
import com.formulario.form.entity.Usuario;
import com.formulario.form.mapper.UsuarioFactory;
import com.formulario.form.mapper.UsuarioMapper;
import com.formulario.form.patterns.validacao.UsuarioValidator;
import com.formulario.form.patterns.validacao.ValidacaoStrategy;
import com.formulario.form.patterns.validacao.ValidarCPF;
import com.formulario.form.patterns.validacao.ValidarEmail;
import com.formulario.form.patterns.validacao.logger.LoggerSingleton;
import com.formulario.form.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//S — Single Responsibility Principle
//Facade=Ele centraliza a lógica de criação, validação e persistência, expondo uma interface simples para o Controller.
// Facade Pattern + Strategy + Factory
import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor //Cria os construtores de tudo que eu definir como private e final

@Service
public class UsuarioService {
    private final UsuarioRepository repository;
    private final UsuarioValidator validator;

    public UsuarioDto salvarUsuario(UsuarioDto dto) {

        validator.validar(dto);

        if (repository.existsByCpf(dto.getCpf())) {
            throw new ValidationException("Cpf já cadastrado : " + dto.getCpf());
        }
        if (repository.existsByEmail(dto.getEmail())) {
            throw new ValidationException("Email já cadastrado : " + dto.getEmail());
        }
        // Factory Method: criação do objeto Usuarioo
        Usuario usuario = UsuarioFactory.criarUsuario(dto);

        // Persistência (Salva o usuario)
        Usuario salvo = repository.save(usuario);

        //Logger  Singleton
        LoggerSingleton.getInstance().log("Usuário criado: " + salvo.getNome());

        // Mapper para retornar DTO
        return UsuarioMapper.toDto(salvo);
    }

    public List<UsuarioDto> listarUsuarios() {
        return repository.findAll()
                .stream()
                .map(UsuarioMapper::toDto)
                .collect(Collectors.toList());
    }
}