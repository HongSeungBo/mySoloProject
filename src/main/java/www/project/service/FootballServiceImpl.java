package www.project.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import www.project.repository.FootballDAO;

@Slf4j
@Service
public class FootballServiceImpl implements FootballService{
	
	@Inject
	private FootballDAO fbdao;
}
