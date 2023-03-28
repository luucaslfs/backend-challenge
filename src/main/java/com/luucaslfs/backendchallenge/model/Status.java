package com.luucaslfs.backendchallenge.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "status_name")
    private String statusName;

    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Subscription> subscriptionList;

}