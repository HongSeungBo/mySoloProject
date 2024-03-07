package www.project.repository;

import java.util.List;

import www.project.domain.football.FootballDTO;
import www.project.domain.football.FootballVO;

public interface FootballDAO {

	int register(FootballVO fbvo);

	List<FootballVO> getFootballList();

	FootballVO getSelectOneDetailStadium(String fcode);
}
