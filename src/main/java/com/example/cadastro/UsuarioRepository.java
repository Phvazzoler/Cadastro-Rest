package com.example.cadastro;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    Pageable id(UUID id);

    Pageable id(UUID id);

    Pageable id(UUID id);
}
