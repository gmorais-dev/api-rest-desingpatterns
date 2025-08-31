package com.formulario.form.controller;

import com.formulario.form.dto.UsuarioDto;
import com.formulario.form.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Facade Pattern : : expõe métodos simples para o Controller
@RestController
@RequestMapping("api/usuarios")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    public ResponseEntity<UsuarioDto> cria(@RequestBody UsuarioDto dto){
        return ResponseEntity.ok(service.salvarUsuario(dto)); // Facade Pattern
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> listarUsuarios() {
        return ResponseEntity.ok(service.listarUsuarios());
    }
}
