package com.sideproject.animereminder.service;

import com.sideproject.animereminder.bean.Profile;

public interface ProfileService {
	Profile findProfile(Long id);
	
	void deleteProfile(Long id);
	
	Profile addProfile(Profile p);
	
	Profile updateProfile(Long id, Profile p);
}
