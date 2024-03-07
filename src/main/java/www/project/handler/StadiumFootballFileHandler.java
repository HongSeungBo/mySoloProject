package www.project.handler;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import www.project.domain.football.FootballStadiumFileVO;

@Slf4j
@Component
public class StadiumFootballFileHandler {
	private final String UP_DIR = "D:\\file\\java\\fileupload";
	
	public FootballStadiumFileVO sfvo(MultipartFile file) {
		FootballStadiumFileVO sfvo = new FootballStadiumFileVO();
		
		String stadium = "\\stadium\\football";
		
		File folders = new File(UP_DIR, stadium);
		
		if(!folders.exists()) {
			folders.mkdirs();
		}
		
		sfvo.setSaveDir(stadium);
		
		String originalFileName = file.getOriginalFilename();
		String fileName = originalFileName.substring(originalFileName.lastIndexOf(File.separator)+1);
		sfvo.setFileName(fileName);
		
		UUID uuid = UUID.randomUUID();
		sfvo.setUuid(uuid.toString());
		
		String fileAllName = uuid.toString()+"-"+fileName;
		
		File storeFile = new File(folders, fileAllName);
		
		try {
			file.transferTo(storeFile);
			File thumbNail = new File(folders, uuid.toString()+"_th_"+fileName);
			Thumbnails.of(storeFile).size(100, 100).toFile(thumbNail);
		} catch (Exception e) {
			log.info("tmt파일 핸들러 오류");
			e.printStackTrace();
		}
		return sfvo;
	}
}
