package www.project.repository;

import java.util.List;

import www.project.domain.football.FootballDTO;
import www.project.domain.football.FootballStadiumFileVO;
import www.project.domain.football.FootballVO;

public interface StadiumDAO {

	List<FootballDTO> getFootballList();

	FootballStadiumFileVO getSelectFileOneFcode(String fCode);

}
