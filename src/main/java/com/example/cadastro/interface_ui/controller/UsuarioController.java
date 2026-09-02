package com.example.cadastro.interface_ui.controller;

import com.example.cadastro.UsuarioRepository;
import com.example.cadastro.application.service.UsuarioService;
import com.example.cadastro.domain.entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {

    final UsuarioService usuarioService;


    @GetMapping
    public List<Usuario> listarTodosUsuarios() {
        return  usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public Usuario BuscarUsuarioPorId(@PathVariable UUID id) {
        return usuarioService.findById(id);
    }

    @PostMapping
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario){
       return usuarioService.save(usuario);
    }
    @PutMapping("/{id}")
    //PutMapping = é o caminho que ele vai puxar o id

    public Usuario atualizarUsuario(@PathVariable UUID id, @RequestBody Usuario usuario) {
        return usuarioService.update(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void excluirUsuario( @PathVariable UUID id){
        usuarioService.delete(id);
    }
}



