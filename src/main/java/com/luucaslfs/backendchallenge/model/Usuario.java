package com.luucaslfs.backendchallenge.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode(of = "id")

public class Usuario {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(mappedBy = "usuario")
    private Assinatura assinatura;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "created_at")
    private Timestamp createdAt;

    public Usuario(RequestUsuario requestUsuario) {
        this.fullName = requestUsuario.fullName();
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }
}
