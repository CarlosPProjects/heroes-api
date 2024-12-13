package com.stoodiow.heroesapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HeroDto {
    private Long id;
    private String name;
    private String publisher;
    private String alter_ego;
    private String first_appearance;
    private String[] characters;
}
