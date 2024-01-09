package www.project.handler;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import www.project.domain.TmtFileVO;

@Slf4j
@Component
public class TmtFileHandler {
	private final String UP_DIR = "D:\\file\\java\\fileupload";
	
	public TmtFileVO tfvo(MultipartFile file) {
		TmtFileVO tfvo = new TmtFileVO();
		
		String saveDir = "tmtfile";
		File folders = new File(UP_DIR, saveDir);
		
		if(!folders.exists()) {
			folders.mkdirs();
		}
		
		tfvo.setSaveDir(saveDir);
		
		String originalFileName = file.getOriginalFilename();
		String fileName = originalFileName.substring(originalFileName.lastIndexOf(File.separator)+1);
		tfvo.setFileName(fileName);
		
		UUID uuid = UUID.randomUUID();
		tfvo.setUuid(uuid.toString());
		
		String fileAllName = uuid.toString()+"_"+fileName;
		
		File storeFile = new File(folders, fileAllName);
		
		try {
			file.transferTo(storeFile);
		} catch (Exception e) {
			log.info("tmt파일 핸들러 오류");
			e.printStackTrace();
		}
		
		return tfvo;
	}
}
