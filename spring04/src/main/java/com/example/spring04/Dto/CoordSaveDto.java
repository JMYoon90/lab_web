package com.example.spring04.Dto;

import com.example.spring04.domain.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CoordSaveDto {
	
	private Integer id;
	private String address;
	private double lat;
	private double lng;

	
	public Map toEntity() {
		return Map.builder()
				.id(id).address(address).lat(lat).lng(lng)
				.build();
	}
}
