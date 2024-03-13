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
import www.project.domain.football.FootballDetailDTO;
import www.project.domain.football.FootballStadiumDetailFileVO;
import www.project.domain.football.FootballStadiumDetailVO;
import www.project.domain.football.FootballStadiumFileVO;
import www.project.domain.football.FootballVO;
import www.project.handler.FootballDetailStadiumFileHandler;
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
	private FootballDetailStadiumFileHandler sdfh;
	
	@Inject
	private TmtFileHandler tfh;
	
	@Inject
	private TmtFileService tfsv;
	
	@GetMapping("/stadiumRG")
	public void register() {}
	
	@PostMapping("/stadiumRG")
	public String register(FootballVO fbvo, @RequestParam(name="fFile")MultipartFile file) {
		FootballDTO fdto = new FootballDTO();
		fdto.setFvo(fbvo);
		if(file.getSize()>0) {
			FootballStadiumFileVO sfvo = sfh.sfvo(file);
			fdto.setFsfvo(sfvo);
		}
		int isOk = fbsv.registerStadium(fdto);
		return "index";
	}
	
	@GetMapping("/detailStadium")
	public String detailStadium(Model m, @RequestParam("fcode")String fcode){
		FootballDTO fdto = new FootballDTO();
		fdto.setFvo(fbsv.getSelectOneDetailStadium(fcode));
		fdto.setFsfvo(fbsv.getSelectOneDetailStadiumFile(fcode));
		m.addAttribute("fdto", fdto);
		
		List<FootballDetailDTO> list = fbsv.getSelectListDetail(fcode);
		m.addAttribute("list", list);
		return "/football/detailStadium";
	}
	
	@PostMapping(value = "/tmtfile", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TmtFileVO> tmtfile(@RequestParam(name="file")MultipartFile file){
		TmtFileVO tfvo = tfh.tfvo(file);
		int isOk = tfsv.saveInfo(tfvo);
		if(isOk>0) {
			return new ResponseEntity<TmtFileVO>(tfvo, HttpStatus.OK);			
		}else {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value = "/AddDetailStadium", produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> AddDetailStadium(@RequestParam(name="fFile")MultipartFile file, FootballStadiumDetailVO fsdvo){
		FootballDetailDTO fddto = new FootballDetailDTO();
		fddto.setFsdvo(fsdvo);
		FootballStadiumDetailFileVO fsdfvo = sdfh.fsdfvo(file);
		fsdfvo.setFcode(fsdvo.getFcode());
		fsdfvo.setStadiumDetailName(fsdvo.getStadiumDetailName());
		fddto.setFsdfvo(fsdfvo);
		int isOk = fbsv.registerDetailStadium(fddto);
		return isOk>0? new ResponseEntity<String>("1",HttpStatus.OK) : new ResponseEntity<String>("0",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
