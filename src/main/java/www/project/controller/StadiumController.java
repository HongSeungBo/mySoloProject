package www.project.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import www.project.domain.football.FootballDTO;
import www.project.domain.football.FootballVO;
import www.project.service.StadiumService;

@Slf4j
@RequestMapping("/stadium/*")
@Controller
public class StadiumController {
	
	@Inject
	private StadiumService ssv;
	
	@GetMapping("/AllStadium")
	public void ListAllStadium(Model m) {
		log.info("시작 >>>>>>>>>>>>>>>111111");
		List<FootballDTO> list = ssv.getFootballList();
		log.info("최종 list >>>>>>>> " + list);
		m.addAttribute("list", list);
	}
}