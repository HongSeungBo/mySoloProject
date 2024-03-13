package www.project.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import www.project.domain.football.FootballDTO;
import www.project.domain.football.FootballDetailDTO;
import www.project.domain.football.FootballStadiumDetailFileVO;
import www.project.domain.football.FootballStadiumDetailVO;
import www.project.domain.football.FootballStadiumFileVO;
import www.project.domain.football.FootballVO;
import www.project.repository.FootballDAO;
import www.project.repository.FootballStadiumDetailDAO;
import www.project.repository.FootballStadiumDetailFileDAO;
import www.project.repository.FootballStadiumFileDAO;

@Slf4j
@Service
public class FootballServiceImpl implements FootballService{
	
	@Inject
	private FootballDAO fbdao;

	@Inject
	private FootballStadiumFileDAO sfdao;
	
	@Inject
	private FootballStadiumDetailDAO fsddao;
	
	@Inject
	private FootballStadiumDetailFileDAO fsdfdao;
	
	@Override
	public int registerStadium(FootballDTO fdto) {
		int isOk = fbdao.register(fdto.getFvo());
		if(isOk>0 && fdto.getFsfvo()!=null) {
			fdto.getFsfvo().setFcode(fdto.getFvo().getFcode());
			isOk = sfdao.register(fdto.getFsfvo());
		}
		return 0;
	}

	@Override
	public FootballVO getSelectOneDetailStadium(String fcode) {
		FootballVO fbvo = fbdao.getSelectOneDetailStadium(fcode);
		return fbvo;
	}

	@Override
	public FootballStadiumFileVO getSelectOneDetailStadiumFile(String fcode) {
		FootballStadiumFileVO fbsfvo = sfdao.getSelectOneDetailStadiumFile(fcode);
		return fbsfvo;
	}

	@Override
	@Transactional
	public int registerDetailStadium(FootballDetailDTO fddto) {
		int isOk = fsddao.registerDetailInfo(fddto.getFsdvo());
		isOk = fsdfdao.registerDetailFileInfo(fddto.getFsdfvo());
		return isOk;
	}

	@Override
	public List<FootballDetailDTO> getSelectListDetail(String fcode) {
		List<FootballDetailDTO> list = new ArrayList<>();
		List<FootballStadiumDetailVO> listvo = fsddao.getSelectListDetail(fcode);
		for(int i=0;i<listvo.size();i++) {
			FootballDetailDTO fddto = new FootballDetailDTO();
			String code = listvo.get(i).getFcode();
			String name = listvo.get(i).getStadiumDetailName();
			FootballStadiumDetailFileVO fsdfvo = fsdfdao.getSelectOneDetailFile(code, name);
			fddto.setFsdvo(listvo.get(i));
			fddto.setFsdfvo(fsdfvo);
			list.add(fddto);
		}
		return list;
	}
}
