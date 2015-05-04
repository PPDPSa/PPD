package ppd.psa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ppd.psa.dao.CampagneDao;
import ppd.psa.model.Campagne;

@Component
public class CampagneService {

	@Autowired
	private CampagneDao campagneDao;
	
	public void  saveCampagne(Campagne campagne){
		campagneDao.saveCampagne(campagne);
	}

	public List<Campagne> getAll() {
		return campagneDao.getAll();
	}
}
