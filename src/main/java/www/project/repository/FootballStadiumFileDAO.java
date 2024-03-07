package www.project.repository;

import www.project.domain.football.FootballStadiumFileVO;

public interface FootballStadiumFileDAO {

	int register(FootballStadiumFileVO sfvo);

	FootballStadiumFileVO getSelectFileOneFcode(String fCode);

	FootballStadiumFileVO getSelectOneDetailStadiumFile(String fcode);
}
