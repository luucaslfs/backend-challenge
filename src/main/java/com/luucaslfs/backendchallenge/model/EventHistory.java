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
    @Column(name = "event_history_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "eventHistory")
    private Subscription subscription;

    @Column(name = "subscription_id")
    private int subscriptionId;

    @Column(name = "type")
    private String type;

    @Column(name = "created_at")
    private Timestamp createdAt;



}