package com.stoodiow.heroesapi.service.impl;

import com.stoodiow.heroesapi.dto.HeroDto;
import com.stoodiow.heroesapi.entity.Hero;
import com.stoodiow.heroesapi.exception.ResourceNotFoundException;
import com.stoodiow.heroesapi.mapper.HeroMapper;
import com.stoodiow.heroesapi.repository.HeroRepository;
import com.stoodiow.heroesapi.service.HeroService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HeroServiceImpl implements HeroService {

    private final HeroRepository heroRepository;

    @Override
    public HeroDto createHero(HeroDto heroDto) {

        Hero hero = HeroMapper.mapToHero(heroDto);
        Hero savedHero = heroRepository.save(hero);
        return HeroMapper.mapToHeroDto(savedHero);
    }

    @Override
    public HeroDto getHeroById(Long heroId) {

        Hero hero = heroRepository.findById(heroId).orElseThrow(
                () -> new ResourceNotFoundException("Hero with id " + heroId + " not found")
        );
        return HeroMapper.mapToHeroDto(hero);
    }

    @Override
    public List<HeroDto> getAllHeroes() {

        List<Hero> heroes = heroRepository.findAll();
        return heroes.stream().map(HeroMapper::mapToHeroDto).toList();
    }

    @Override
    public HeroDto updateHero(Long heroId, HeroDto updatedHero) {

        Hero hero = heroRepository.findById(heroId).orElseThrow(
                () -> new ResourceNotFoundException("Hero with id " + heroId + " not found")
        );

        hero.setName(updatedHero.getName());
        hero.setPublisher(updatedHero.getPublisher());
        hero.setAlter_ego(updatedHero.getAlter_ego());
        hero.setFirst_appearance(updatedHero.getFirst_appearance());
        hero.setCharacters(updatedHero.getCharacters());

        Hero updatedHeroObj = heroRepository.save(hero);

        return HeroMapper.mapToHeroDto(updatedHeroObj);

    }

    @Override
    public void deleteHero(Long heroId) {

        heroRepository.findById(heroId).orElseThrow(
                () -> new ResourceNotFoundException("Hero with id " + heroId + " not found")
        );

        heroRepository.deleteById(heroId);
    }

}
