package com.stoodiow.heroesapi.mapper;

import com.stoodiow.heroesapi.dto.HeroDto;
import com.stoodiow.heroesapi.entity.Hero;

import java.util.ArrayList;
import java.util.Arrays;

public class HeroMapper {

    public static HeroDto mapToHeroDto(Hero hero) {
        return new HeroDto(
                hero.getId(),
                hero.getName(),
                hero.getPublisher(),
                hero.getAlter_ego(),
                hero.getFirst_appearance(),
                hero.getCharacters().toArray(new String[0])
        );
    }

    public static Hero mapToHero(HeroDto heroDto) {
        return new Hero(
                heroDto.getId(),
                heroDto.getName(),
                heroDto.getPublisher(),
                heroDto.getAlter_ego(),
                heroDto.getFirst_appearance(),
                heroDto.getCharacters() != null
                        ? Arrays.asList(heroDto.getCharacters())
                        : new ArrayList<>()
        );
    }

}
