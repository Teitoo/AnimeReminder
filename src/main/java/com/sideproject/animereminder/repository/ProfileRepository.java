package com.sideproject.animereminder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sideproject.animereminder.bean.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long>{

}
