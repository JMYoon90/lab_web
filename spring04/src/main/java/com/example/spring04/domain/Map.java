package com.example.spring04.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
@Entity(name = "KAKAOMAP")
@SequenceGenerator(name = "MAP_SEQ_GEN", sequenceName = "KAKAOMAP_SEQ1" , initialValue = 1, allocationSize = 1)
public class Map {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MAP_SEQ_GEN")
	private Integer id;	
	private String address;
	private String title;
	private String content;
	private double lat;
	private double lng;
	
	
	
}
