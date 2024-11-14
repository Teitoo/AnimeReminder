package com.sideproject.animereminder.service;

import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sideproject.animereminder.bean.Anime;
import com.sideproject.animereminder.bean.Profile;
import com.sideproject.animereminder.repository.ProfileRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	ProfileRepository pRepo;

	@Override
	public Profile findMyProfile(Long id) {
		return pRepo.findById(id).orElseThrow();
	}

	@Override
	public void deleteProfile(Long id) {
		Optional <Profile> res = pRepo.findById(id);
		if (res.isPresent()) {
			pRepo.deleteById(id);
			log.info("delete id={}", id);
			return;
		}
		log.info("failed to delete Profile");
	}

	@Override
	public Profile addProfile(Profile p) {
		return pRepo.save(Profile.builder()
				.name(p.getName())
				.animeSet(p.getAnimeSet() != null ? p.getAnimeSet() : new HashSet<Anime>())
				.build());
	}

	@Override
	public Profile updateProfile(Long id, Profile p) {
		Optional <Profile> res = pRepo.findById(id);
		if(res.isPresent()) {
			Profile profile = res.get();
			profile.setName(p.getName() != null ? p.getName() : profile.getName());
			return pRepo.save(profile);
		}
		return null;
	}

}
