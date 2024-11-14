package com.sideproject.animereminder.bean;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sideproject.animereminder.repository.AnimeRepository;
import com.sideproject.animereminder.repository.ProfileRepository;

@SpringBootTest
public class EntityTests {
	@Autowired
	ProfileRepository pRepo;
	
	@Autowired
	AnimeRepository aRepo;
	
	@BeforeEach
	public void clean() {
		pRepo.deleteAll();
		aRepo.deleteAll();
	}
	
	@Test
	public void test1() {
		Profile p1 = Profile.builder().name("Tet").build();
		Anime a1 = Anime.builder().name("Makeine").episode(12)
				.updateTime(LocalDateTime.of(2024, 06, 30, 1, 0)).build();
		Anime a2 = Anime.builder().name("Fate/Zero").episode(25)
				.updateTime(LocalDateTime.of(2015, 06, 30, 1, 0)).build();

		Set<Anime> aSet = new HashSet<>();
		aSet.add(a1);aSet.add(a2);
		p1.setAnimeSet(aSet);

		pRepo.save(p1);
		aRepo.save(a1);aRepo.save(a2);
	}
}
