package ppd.psa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ppd.psa.dao.ContactDao;
import ppd.psa.model.Contact;

public class ContactService {

	@Autowired
	ContactDao contactDao;
	
	 public void save (Contact contact){
		 contactDao.save(contact);
	 }
	 
	 public List<Contact> getAll(){
		 return contactDao.getAll();
	 }
}
