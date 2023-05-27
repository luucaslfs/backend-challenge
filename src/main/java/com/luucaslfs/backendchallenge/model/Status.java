package com.luucaslfs.backendchallenge.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "status")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Status {

    @Id
    @Column(name = "status_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "status_name")
    private String statusName;

    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL)
    @JsonBackReference
    @ToString.Exclude
    private List<Subscription> subscriptionList;

}