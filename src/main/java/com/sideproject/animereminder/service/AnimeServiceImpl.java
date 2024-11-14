package com.sideproject.animereminder.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sideproject.animereminder.bean.Anime;
import com.sideproject.animereminder.repository.AnimeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AnimeServiceImpl implements AnimeService {
	@Autowired
	AnimeRepository aRepo;


	@Override
	public List<Anime> showAllAnime() {
		return aRepo.findAll();

	}

	@Override
	public void deleteAnime(Long id) {
		aRepo.deleteById(id);
		log.info("delete id={}", id);
	}

	@Override
	public Anime addNewAnime(Anime a) {
		return Anime.builder().build();
	}

	@Override
	public Anime updateAnimeData(Long id, String name, Date updateTime, int episode) {
		Optional<Anime> res = aRepo.findById(id);
		if(res.isPresent()) {
			Anime a = res.get();
			a = Anime.builder().name(name).updateTime(updateTime).episode(episode).build();
			return a;
		}
		return null;
	}

	@Override
	public void updateCurrentEpisode(Long id) {
		Optional<Anime> res = aRepo.findById(id);
		if(res.isPresent()) {
			Anime a = res.get();
			int currentEpisode = a.getEpisode();
			a.setEpisode(currentEpisode-1);
		}
	}

	@Override
	public boolean checkTime(Long id) {
		// TODO Auto-generated method stub
		return false;
	}


}
