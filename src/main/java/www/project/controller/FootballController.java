package www.project.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import www.project.domain.FootballVO;
import www.project.domain.TmtFileVO;
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
	private TmtFileHandler tfh;
	
	@Inject
	private TmtFileService tfsv;
	
	@GetMapping("/stadiumRG")
	public void register() {}
	
	@PostMapping("/stadiumRG")
	public String register(FootballVO fvo) {
		
		return "index";
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
