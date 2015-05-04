package ppd.psa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import ppd.psa.model.Campagne;
import ppd.psa.util.SequenceDao;

@Component
public class CampagneDao {
	@Autowired
	private MongoOperations mongoOperations;
	
	private static final String HOSTING_SEQ_KEY = "Campagne";
	
	@Autowired
	private SequenceDao sequenceDao;
	
	public void saveCampagne(Campagne campagne){
		campagne.setId(sequenceDao.getNextSequenceId(HOSTING_SEQ_KEY));
		mongoOperations.save(campagne);
	}

	public List<Campagne> getAll() {
		return mongoOperations.findAll(Campagne.class);
	}
}
