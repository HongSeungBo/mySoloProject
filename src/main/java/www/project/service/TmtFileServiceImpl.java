package www.project.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import www.project.domain.TmtFileVO;
import www.project.repository.TmtFileDAO;

@Slf4j
@Service
public class TmtFileServiceImpl implements TmtFileService{

	@Inject
	private TmtFileDAO tfdao;

	@Override
	public int saveInfo(TmtFileVO tfvo) {
		return tfdao.saveInfo(tfvo);
	}
}
