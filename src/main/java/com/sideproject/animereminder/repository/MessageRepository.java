package com.sideproject.animereminder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sideproject.animereminder.bean.Message;

public interface MessageRepository extends JpaRepository<Message, Long>{

}
