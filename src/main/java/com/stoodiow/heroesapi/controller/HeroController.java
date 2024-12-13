package com.stoodiow.heroesapi.controller;

import com.stoodiow.heroesapi.dto.HeroDto;
import com.stoodiow.heroesapi.service.HeroService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/heroes")
public class HeroController {

    private HeroService heroService;

    // Build Add Employee REST API
    @PostMapping
    public ResponseEntity<HeroDto> createHero(@RequestBody HeroDto heroDto) {
        HeroDto savedHero = heroService.createHero(heroDto);
        return new ResponseEntity<>(savedHero, HttpStatus.CREATED);
    }

    // Build Get Hero REST API
    @GetMapping("{id}")
    public ResponseEntity<HeroDto> getHeroById(@PathVariable("id") Long heroId) {
        HeroDto heroDto = heroService.getHeroById(heroId);
        return new ResponseEntity<>(heroDto, HttpStatus.OK);
    }

    // Build Get All Heroes REST API
    @GetMapping
    public ResponseEntity<List<HeroDto>> getAllHeroes() {
        List<HeroDto> heroes = heroService.getAllHeroes();
        return new ResponseEntity<>(heroes, HttpStatus.OK);
    }

    // Build Update Hero REST API
    @PutMapping("{id}")
    public ResponseEntity<HeroDto> updateHero(@PathVariable("id") Long heroId, @RequestBody HeroDto updatedHero) {
        HeroDto updatedHeroDto = heroService.updateHero(heroId, updatedHero);
        return new ResponseEntity<>(updatedHeroDto, HttpStatus.OK);
    }

    // Build Delete Hero REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteHero(@PathVariable("id") Long heroId) {
        heroService.deleteHero(heroId);
        return new ResponseEntity<>("Hero deleted successfully.", HttpStatus.OK);
    }

}
