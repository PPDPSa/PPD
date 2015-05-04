package ppd.psa.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ppd.psa.dao.ActionDao;
import ppd.psa.model.Action;
import ppd.psa.util.SendMail;

@Service
public class ActionService {

	@Autowired
	private ActionDao actionDao;
	
	@Autowired
	SendMail sendMail;
	
	public void saveAction(Action action) {
		
		
		sendMail.generateAndSendEmail(action.getEncours().getMailType().get(0), action.getPsaBox());
		actionDao.saveAction(action);
	}

	public List<Action> getAll() {
		return actionDao.getAll();
	}

}
