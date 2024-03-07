package www.project.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import www.project.domain.football.FootballDTO;
import www.project.domain.football.FootballStadiumFileVO;
import www.project.domain.football.FootballVO;
import www.project.repository.FootballDAO;
import www.project.repository.FootballStadiumFileDAO;

@Slf4j
@Service
public class FootballServiceImpl implements FootballService{
	
	@Inject
	private FootballDAO fbdao;

	@Inject
	private FootballStadiumFileDAO sfdao;
	
	@Override
	public int registerStadium(FootballDTO fdto) {
		int isOk = fbdao.register(fdto.getFbvo());
		if(isOk>0 && fdto.getFbsfvo()!=null) {
			fdto.getFbsfvo().setFcode(fdto.getFbvo().getFcode());
			isOk = sfdao.register(fdto.getFbsfvo());
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
}
