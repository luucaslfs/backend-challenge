package com.luucaslfs.backendchallenge.service;

import com.luucaslfs.backendchallenge.model.RequestUsuario;
import com.luucaslfs.backendchallenge.model.Usuario;
import com.luucaslfs.backendchallenge.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario registerUsuario(RequestUsuario data) {
        Usuario newUsuario = new Usuario(data);
        return usuarioRepository.save(newUsuario);
    }

    public Optional<Usuario> updateUsuario(RequestUsuario data) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(data.id());
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            usuario.setFullName(data.fullName());
            // Set other fields if necessary
            // Perform any additional business logic or validation here
            return Optional.of(usuarioRepository.save(usuario));
        } else {
            return Optional.empty();
        }
    }

}
