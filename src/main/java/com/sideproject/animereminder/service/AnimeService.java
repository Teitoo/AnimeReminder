package com.sideproject.animereminder.service;

import java.util.Date;
import java.util.List;

import com.sideproject.animereminder.bean.Anime;

public interface AnimeService {
	List<Anime> showAllAnime();
	
	void deleteAnime(Long id);
	
	Anime addNewAnime(Anime a);
	
	Anime updateAnimeData(Long id, String name, Date updateTime, int episode);
	
	void updateCurrentEpisode(Long id);
	
	boolean checkTime(Long id);
}
