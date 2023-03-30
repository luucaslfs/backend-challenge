package com.luucaslfs.backendchallenge.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    @ToString.Exclude
    private List<Subscription> subscriptionList;

}