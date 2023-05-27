package com.luucaslfs.backendchallenge.controller;

import com.luucaslfs.backendchallenge.model.RequestUsuario;
import com.luucaslfs.backendchallenge.model.Usuario;
import com.luucaslfs.backendchallenge.repository.UsuarioRepository;
import com.luucaslfs.backendchallenge.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios(){
        List<Usuario> allUsuarios = usuarioService.getAllUsuarios();
        return ResponseEntity.ok(allUsuarios);
    }

    @PostMapping
    public ResponseEntity<Void> registerUsuario(@RequestBody @Valid RequestUsuario data){
        Usuario newUsuario = usuarioService.registerUsuario(data);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateUsuario(@RequestBody @Valid RequestUsuario data){
        Optional<Usuario> optionalUsuario = usuarioService.updateUsuario(data);
        if (optionalUsuario.isPresent()) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
