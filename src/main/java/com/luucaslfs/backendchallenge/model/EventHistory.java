package com.luucaslfs.backendchallenge.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "event_history")
public class EventHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subscription_id")
    @ToString.Exclude
    private Subscription subscription;

    @Column(name = "type")
    private String type;

    @Column(name = "created_at")
    private Timestamp createdAt;

}