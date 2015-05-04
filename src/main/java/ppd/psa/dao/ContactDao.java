package ppd.psa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import ppd.psa.model.Contact;
import ppd.psa.util.SequenceDao;

@Component
public class ContactDao {

	@Autowired
	private MongoOperations mongoOperations;

	private static final String HOSTING_SEQ_KEY = "Contact";
	
	@Autowired
	private SequenceDao sequenceDao;
	
	public ContactDao() {
		ApplicationContext ctx = new GenericXmlApplicationContext(
				"SpringMongoConfig.xml");
		this.mongoOperations = (MongoOperations) ctx.getBean("mongoTemplate");
	}

	public void save(Contact contact) {
		contact.setId(sequenceDao.getNextSequenceId(HOSTING_SEQ_KEY));
		mongoOperations.save(contact);
	}

	public List<Contact> getAll() {
		return mongoOperations.findAll(Contact.class);
	}

	public Contact findContact(String login){
		Query query3 = new Query();
		query3.addCriteria(Criteria.where("login").in(login));
		List<Contact> contacts = mongoOperations.find(query3, Contact.class);
		if(contacts.size() == 0){
			return null;
		}
		return contacts.get(0);
	}
	
	public void modifyContact(Contact contact) {
		mongoOperations.save(contact);
	
	}
}
