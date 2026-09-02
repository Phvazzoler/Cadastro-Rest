package com.example.cadastro.application.service;

import com.example.cadastro.UsuarioRepository;
import com.example.cadastro.domain.entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service

public class UsuarioService {
    final UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
    public Usuario findById(@PathVariable UUID id) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        if (usuarioOpt.isPresent()) {
            return usuarioOpt.get();
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario update(UUID id, Usuario usuario) {
        Usuario usuarioExistente = findById(id);
        usuarioExistente.setNome(usuario.getNome());
        usuarioExistente.setEmail(usuario.getEmail());
        usuarioExistente.setCpf(usuario.getCpf());
        return usuarioRepository.save(usuarioExistente);
    }

    public void delete(UUID id) {
    usuarioRepository.delete(findById(id));
    }
}
