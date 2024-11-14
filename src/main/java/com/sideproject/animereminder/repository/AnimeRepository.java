package com.sideproject.animereminder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sideproject.animereminder.bean.Anime;

public interface AnimeRepository extends JpaRepository<Anime, Long>{

}
