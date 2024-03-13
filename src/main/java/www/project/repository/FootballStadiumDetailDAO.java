package www.project.repository;

import java.util.List;

import www.project.domain.football.FootballStadiumDetailVO;

public interface FootballStadiumDetailDAO {

	int registerDetailInfo(FootballStadiumDetailVO fsdvo);

	List<FootballStadiumDetailVO> getSelectListDetail(String fcode);

}
