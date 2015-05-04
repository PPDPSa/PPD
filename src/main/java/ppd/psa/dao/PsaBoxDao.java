package ppd.psa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import ppd.psa.model.Contact;
import ppd.psa.model.PsaBox;
import ppd.psa.util.SequenceDao;

@Component
public class PsaBoxDao {

	@Autowired
	private MongoOperations mongoOperations;
	
	private static final String HOSTING_SEQ_KEY = "Psabox";
	
	@Autowired
	private SequenceDao sequenceDao;
	
	public PsaBoxDao() {
		ApplicationContext ctx = new GenericXmlApplicationContext("SpringMongoConfig.xml");
	 this.mongoOperations = 
                (MongoOperations) ctx.getBean("mongoTemplate");
	}
	
	public void savePsaBox(PsaBox psaBox){
		psaBox.setId(sequenceDao.getNextSequenceId(HOSTING_SEQ_KEY));
		mongoOperations.save(psaBox);
	}
	
	public List<PsaBox> getAll(){
		return mongoOperations.findAll(PsaBox.class);
	}
}
