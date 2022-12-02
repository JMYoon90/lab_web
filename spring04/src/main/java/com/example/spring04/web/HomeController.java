package com.example.spring04.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.spring04.domain.Map;
import com.example.spring04.service.MapService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class HomeController {
	
	private final MapService mapService;
	
	@GetMapping("/")
	public String home(Model model) {
        log.info("home()");
        
        List<Map> list = mapService.read();
        model.addAttribute("list", list);
        log.info("size=" + list.size());
        log.info("controller list=" + list);
        
        return "/map/main";
	}

}
