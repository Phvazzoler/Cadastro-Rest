package com.example.cadastro;

import com.example.cadastro.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")


public class UsuarioController {
    final UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> listarTodosUsuarios() {
        return  usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Usuario BuscarUsuarioPorId(@PathVariable UUID id) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        if (usuarioOpt.isPresent()) {
            return usuarioOpt.get();
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }

    @PostMapping
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario){
       return usuarioRepository.save(usuario);
    }
    @PutMapping("/{id}")
    //PutMapping = é o caminho que ele vai puxar o id

    public Usuario atualizarUsuario(@PathVariable UUID id, @RequestBody Usuario usuario) {
        Usuario usuarioExistente = BuscarUsuarioPorId(id);
            usuarioExistente.setNome(usuario.getNome());
            usuarioExistente.setEmail(usuario.getEmail());
            usuarioExistente.setCpf(usuario.getCpf());
            return usuarioRepository.save(usuarioExistente);

    }


    @DeleteMapping("/{id}")
    public void excluirUsuario( @PathVariable UUID id){
        usuarioRepository.deleteById(id);
    }
}



