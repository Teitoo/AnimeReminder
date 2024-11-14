package com.sideproject.animereminder.bean;

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
		Profile p1 = new Profile();
		Anime a1 = Anime.builder().name("Makeine").episode(12)
				.updateTime(java.sql.Date.valueOf("2024-05-12")).build();
		Anime a2 = Anime.builder().name("Fate/Zero").episode(25)
				.updateTime(java.sql.Date.valueOf("2015-05-12")).build();

		p1.setName("Tet");
		a2.setName("Fate/Zero");

		Set<Anime> aSet = new HashSet<>();
		aSet.add(a1);aSet.add(a2);
		p1.setS(aSet);

		pRepo.save(p1);
		aRepo.save(a1);aRepo.save(a2);
	}
}
