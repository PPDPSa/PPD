package ppd.psa.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ppd.psa.dao.ContactDao;
import ppd.psa.model.Contact;

@Controller
@RequestMapping(value="/contact")
public class ContactController {

	private static final Logger logger = LoggerFactory.getLogger("ngotioi");
	@Autowired
	ContactDao contactDao;
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	 public void save ( @RequestBody Contact contact){
		logger.debug(contact.toString());
		contactDao.save(contact);
	 }
	 
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	 public void update ( @RequestBody Contact contact){
		 contactDao.modifyContact(contact);
	 }
	 
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List<Contact> getAll(){
    	return contactDao.getAll();
	 }
    
}
