package com.example.spring04.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.spring04.Dto.CoordSaveDto;
import com.example.spring04.service.MapService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MapController {

	private final MapService mapService;
	
	@RequestMapping(value="/map/updateCoords", method= {RequestMethod.POST})
	public String updateCoords(@RequestBody CoordSaveDto dto) {
		log.info("dto = {}", dto);
		
		mapService.saveCoord(dto);
		
		return "/map/main";
	}
	
}
