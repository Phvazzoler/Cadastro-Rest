package com.example.cadastro;

import com.example.cadastro.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

}
