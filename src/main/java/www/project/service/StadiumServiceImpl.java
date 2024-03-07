package www.project.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import www.project.domain.football.FootballDTO;
import www.project.domain.football.FootballStadiumFileVO;
import www.project.domain.football.FootballVO;
import www.project.repository.FootballDAO;
import www.project.repository.FootballStadiumFileDAO;
import www.project.repository.StadiumDAO;

@Slf4j
@Service
public class StadiumServiceImpl implements StadiumService{
	
	@Inject
	private StadiumDAO sdao;
	
	@Inject
	private FootballDAO fbdao;

	@Inject
	private FootballStadiumFileDAO sfdao;

	@Override
	public List<FootballDTO> getFootballList() {
		List<FootballDTO> list = new ArrayList<>();
		List<FootballVO> fblist = fbdao.getFootballList();
		for(int i=0; i<fblist.size(); i++) {
			FootballDTO dto = new FootballDTO();
			dto.setFbvo(fblist.get(i));
			String fCode = fblist.get(i).getFcode();
			FootballStadiumFileVO fbsfvo = sfdao.getSelectFileOneFcode(fCode);
			dto.setFbsfvo(fbsfvo);
			 list.add(dto);
		}
		return list;
	}
}
