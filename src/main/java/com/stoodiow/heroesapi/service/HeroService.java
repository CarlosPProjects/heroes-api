package com.stoodiow.heroesapi.service;

import com.stoodiow.heroesapi.dto.HeroDto;

import java.util.List;

public interface HeroService {
    HeroDto createHero(HeroDto heroDto);

    HeroDto getHeroById(Long heroId);

    List<HeroDto> getAllHeroes();

    HeroDto updateHero(Long heroId, HeroDto updatedHero);

    void deleteHero(Long heroId);
}
