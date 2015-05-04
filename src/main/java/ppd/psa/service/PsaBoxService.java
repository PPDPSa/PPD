package ppd.psa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ppd.psa.dao.ContactDao;
import ppd.psa.dao.PsaBoxDao;
import ppd.psa.model.Contact;
import ppd.psa.model.PsaBox;

@Component
public class PsaBoxService {

	@Autowired
	private PsaBoxDao psaBoxDao;
	
	@Autowired
	private ContactDao contactDao;
	
	public void savePsaBox(PsaBox psaBox) {
	List<Contact> contacts = psaBox.getContact();
	Contact contactITFR =  contactDao.findContact("ITFR");
	Contact contactSDES = contactDao.findContact("SDES");
	contacts.add(contactSDES);
	contacts.add(contactITFR);
	psaBox.setContact(contacts);
	psaBoxDao.savePsaBox(psaBox);;
	}

	public List<PsaBox> getAll(){
		return psaBoxDao.getAll();
	}
}
