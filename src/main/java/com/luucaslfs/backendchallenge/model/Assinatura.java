package com.luucaslfs.backendchallenge.model;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Timestamp;

@Entity(name = "assinatura")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode(of = "id")
public class Assinatura {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @OneToOne
    @JoinColumn(
            name = "usuario_id",
            referencedColumnName = "id")
    private Usuario usuario;

}

