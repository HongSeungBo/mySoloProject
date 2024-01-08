package www.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import www.project.domain.FootballVO;

@Slf4j
@RequestMapping("/football/*")
@Controller
public class FootballController {
	
	@GetMapping("/stadiumRG")
	public void register() {}
	
	@PostMapping("/stadiumRG")
	public String register(FootballVO fvo) {
		
		return "index";
	}
}
