package ppd.psa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import ppd.psa.model.Action;

@Component
public class ActionDao {

	@Autowired
	private MongoOperations mongoOperations;
	
	public void saveAction(Action action){
		mongoOperations.save(action);
	}

	public List<Action> getAll() {
		return mongoOperations.findAll(Action.class);
	}	
}
