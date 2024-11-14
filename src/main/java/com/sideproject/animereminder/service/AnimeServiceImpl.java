package com.sideproject.animereminder.service;

import java.time.LocalDateTime;
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
		Optional <Anime> res = aRepo.findById(id);
		if (res.isPresent()) {
			aRepo.deleteById(id);
			log.info("delete id={}", id);
			return;
		}
		log.info("failed to delete Anime");
	}

	@Override
	public Anime addNewAnime(Anime a) {
		return aRepo.save(Anime.builder()
				.name(a.getName())
				.episode(a.getEpisode() != null ? a.getEpisode() : 12)
				.updateTime(a.getUpdateTime() != null ? a.getUpdateTime() : LocalDateTime.now())
				.build());
	}

	@Override
	public Anime updateAnimeData(Long id, Anime a) {
		Optional<Anime> res = aRepo.findById(id);
		if (res.isPresent()) {
			Anime anime = res.get();
			anime.setName(a.getName() != null ? a.getName() : anime.getName());
			anime.setUpdateTime(a.getUpdateTime() != null ? a.getUpdateTime() : anime.getUpdateTime());
			anime.setEpisode(a.getEpisode() != null ? a.getEpisode() : anime.getEpisode());
			return aRepo.save(anime);
		}
		return null;
	}

	@Override
	public void updateCurrentEpisode(Long id) {
		Optional<Anime> res = aRepo.findById(id);
		if (res.isPresent()) {
			Anime a = res.get();
			int currentEpisode = a.getEpisode();
			a.setEpisode(currentEpisode - 1);
			aRepo.save(a);
		}
	}

	@Override
	public boolean checkTime(Long id) {
		Anime res = aRepo.findById(id).get();
		if(!res.isEnd()) {
			LocalDateTime n = LocalDateTime.now();
			LocalDateTime t = res.getUpdateTime();
			if(n.isBefore(t) && n.isAfter(t.minusDays(1)))
				return true;
		}
		return false;
	}

}
