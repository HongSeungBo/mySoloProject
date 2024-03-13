package www.project.service;

import java.util.List;

import www.project.domain.football.FootballDTO;
import www.project.domain.football.FootballDetailDTO;
import www.project.domain.football.FootballStadiumDetailFileVO;
import www.project.domain.football.FootballStadiumDetailVO;
import www.project.domain.football.FootballStadiumFileVO;
import www.project.domain.football.FootballVO;

public interface FootballService {

	int registerStadium(FootballDTO fdto);

	FootballVO getSelectOneDetailStadium(String fcode);

	FootballStadiumFileVO getSelectOneDetailStadiumFile(String fcode);

	int registerDetailStadium(FootballDetailDTO fddto);

	List<FootballDetailDTO> getSelectListDetail(String fcode);

}
