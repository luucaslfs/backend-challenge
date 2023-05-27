package com.luucaslfs.backendchallenge.repository;

import com.luucaslfs.backendchallenge.model.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void saveUsuario() {
        Usuario usuario = Usuario.builder()
                .fullName("Lucas")
                .build();

        usuarioRepository.save(usuario);
    }

    @Test
    public void printAllUsuario() {
        List<Usuario> usuarioList =
                usuarioRepository.findAll();

        System.out.println("usuarioList = " + usuarioList);
    }

}