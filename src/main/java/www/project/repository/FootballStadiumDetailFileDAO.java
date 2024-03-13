package www.project.repository;

import org.apache.ibatis.annotations.Param;

import www.project.domain.football.FootballStadiumDetailFileVO;

public interface FootballStadiumDetailFileDAO {

	int registerDetailFileInfo(FootballStadiumDetailFileVO fsdfvo);

	FootballStadiumDetailFileVO getSelectOneDetailFile(@Param("code")String code, @Param("name")String name);

}
