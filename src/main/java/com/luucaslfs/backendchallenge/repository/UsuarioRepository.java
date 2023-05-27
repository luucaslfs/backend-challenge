package com.luucaslfs.backendchallenge.repository;

import com.luucaslfs.backendchallenge.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {}
