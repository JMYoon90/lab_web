package com.example.spring02.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring02.domain.User;
import com.example.spring02.dto.UserCreateDto;
import com.example.spring02.dto.UserUpdateDto;
import com.example.spring02.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/users/")
public class UserController {

	private final UserService userService;
	
	@GetMapping("/list")
	public String list(Model model) {
		log.info("list()");
		
		List<User> list = userService.read();
		
		model.addAttribute("userlist", list);
		
		return "/users/list";
	}
	
	@GetMapping("/create")
	public String Create() {
		log.info("create");
		return "/users/create";
	}
	
	@PostMapping("/userCreate")
	public String userCreate(UserCreateDto dto) {
		log.info("create(dto={})", dto);
		userService.insert(dto);
		return "redirect:/users/list";
	}
	
	@GetMapping("/detail")
	public String Detail(Integer id, Model model) {
		log.info("detail={}", id);
		User user = userService.selectById(id);
		model.addAttribute("user", user);
		return "/users/detail";
	}
	
	@GetMapping("/modify")
	public String Modify(Integer id, Model model) {
		log.info("modify={}", id);
		User user = userService.selectById(id);
		model.addAttribute("user", user);
		return "/users/modify";
	}
	
	@PostMapping("/delete")
	public String Delete(Integer id) {
		log.info("delete(id={})", id);
		userService.delete(id);
		return "redirect:/users/list";
	}
	
	@PostMapping("/modify")
	public String Update(UserUpdateDto dto) {
		log.info("update(dto={}", dto);
		userService.update(dto);
		return "redirect:/users/detail?id=" + dto.getId();
	}
	
	@GetMapping("/signin")
	public String SignInPage() {
		log.info("signInPage");
		return "/users/signin";
	}
	
	@PostMapping("/userSignIn")
	public String SignIn(UserCreateDto dto, HttpServletRequest request) {
		User user = userService.signin(dto);
		HttpSession session = request.getSession();
		if (user != null) {
			session.setAttribute("signIn", user);
			return "redirect:/";
		} else {
			session.setAttribute("signIn", null);
			return "redirect:/users/signin";
		}
	}
}
