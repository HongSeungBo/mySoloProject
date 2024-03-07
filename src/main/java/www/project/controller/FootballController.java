package www.project.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import www.project.domain.TmtFileVO;
import www.project.domain.football.FootballDTO;
import www.project.domain.football.FootballStadiumFileVO;
import www.project.domain.football.FootballVO;
import www.project.handler.StadiumFootballFileHandler;
import www.project.handler.TmtFileHandler;
import www.project.service.FootballService;
import www.project.service.TmtFileService;

@Slf4j
@RequestMapping("/football/*")
@Controller
public class FootballController {
	
	@Inject
	private FootballService fbsv;
	
	@Inject
	private StadiumFootballFileHandler sfh;
	
	@Inject
	private TmtFileHandler tfh;
	
	@Inject
	private TmtFileService tfsv;
	
	@GetMapping("/stadiumRG")
	public void register() {}
	
	@PostMapping("/stadiumRG")
	public String register(FootballVO fbvo, @RequestParam(name="fFile")MultipartFile file) {
		FootballDTO fdto = new FootballDTO();
		fdto.setFbvo(fbvo);
		if(file.getSize()>0) {
			FootballStadiumFileVO sfvo = sfh.sfvo(file);
			fdto.setFbsfvo(sfvo);
		}
		int isOk = fbsv.registerStadium(fdto);
		return "index";
	}
	
	@GetMapping("/detailStadium")
	public String detailStadium(Model m, @RequestParam("fcode")String fcode){
		log.info("fcode >>>> " + fcode);
		FootballDTO fdto = new FootballDTO();
		fdto.setFbvo(fbsv.getSelectOneDetailStadium(fcode));
		fdto.setFbsfvo(fbsv.getSelectOneDetailStadiumFile(fcode));
		m.addAttribute("fdto", fdto);
		return "/football/detailStadium";
	}
	
	@PostMapping(value = "/tmtfile", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TmtFileVO> tmtfile(@RequestParam(name="file")MultipartFile file){
		log.info("file >>> " + file);
		TmtFileVO tfvo = tfh.tfvo(file);
		int isOk = tfsv.saveInfo(tfvo);
		if(isOk>0) {
			return new ResponseEntity<TmtFileVO>(tfvo, HttpStatus.OK);			
		}else {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
