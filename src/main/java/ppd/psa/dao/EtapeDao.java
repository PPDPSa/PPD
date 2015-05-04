package ppd.psa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import ppd.psa.model.Etape;

@Component
public class EtapeDao {

	@Autowired
	private MongoOperations mongoOperations;

	private static final String HOSTING_SEQ_KEY = "Etape";
	
	public List<Etape> getAll() {
		return mongoOperations.findAll(Etape.class);
	}
}
