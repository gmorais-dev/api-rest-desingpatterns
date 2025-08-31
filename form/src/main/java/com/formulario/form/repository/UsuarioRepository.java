package com.formulario.form.repository;

import com.formulario.form.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repository Pattern: abstração do acesso ao banco
@Repository

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
}


