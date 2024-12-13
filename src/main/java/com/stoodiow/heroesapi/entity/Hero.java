package com.stoodiow.heroesapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "heroes")
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "alter_ego")
    private String alter_ego;

    @Column(name = "first_appearance")
    private String first_appearance;

    @ElementCollection
    @CollectionTable(name = "hero_characters", joinColumns = @JoinColumn(name = "hero_id"))
    @Column(name = "character")
    private List<String> characters;
}