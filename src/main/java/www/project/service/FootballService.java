package www.project.service;

import www.project.domain.football.FootballDTO;
import www.project.domain.football.FootballStadiumFileVO;
import www.project.domain.football.FootballVO;

public interface FootballService {

	int registerStadium(FootballDTO fdto);

	FootballVO getSelectOneDetailStadium(String fcode);

	FootballStadiumFileVO getSelectOneDetailStadiumFile(String fcode);

}
