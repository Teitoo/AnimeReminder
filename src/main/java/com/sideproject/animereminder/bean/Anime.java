package com.sideproject.animereminder.bean;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Builder
@Entity
@Data
@Table
public class Anime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String name;
	private Date updateTime;
	private int episode;
	private boolean end;
	
	@ManyToOne
	@JoinColumn(name = "profile_fk")
	private Profile profile;
}

