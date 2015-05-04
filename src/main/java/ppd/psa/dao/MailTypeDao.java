package ppd.psa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import ppd.psa.model.MailType;
import ppd.psa.util.SequenceDao;
@Component
public class MailTypeDao {
 
	@Autowired
	private MongoOperations mongoOperations;
	
	private static final String HOSTING_SEQ_KEY = "mail";
	
	@Autowired
	private SequenceDao sequenceDao;
	
	public void saveMailType(MailType mailtype){
		mailtype.setId(sequenceDao.getNextSequenceId(HOSTING_SEQ_KEY));
		mongoOperations.save(mailtype);
	}
	
	public List<MailType> getAll(){
		return mongoOperations.findAll(MailType.class);
	}
	
	public MailType findByName(String name){
		Query query3 = new Query();
		query3.addCriteria(Criteria.where("nom").in(name));
		 
		List<MailType> userTest3 = mongoOperations.find(query3, MailType.class);
		return userTest3.get(0);
	}
}
