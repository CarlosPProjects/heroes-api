package com.stoodiow.heroesapi.repository;

import com.stoodiow.heroesapi.entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository extends JpaRepository<Hero, Long> {
}
