package ppd.psa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import ppd.psa.model.MailType;
import ppd.psa.service.MailTypeService;

@Controller
@RequestMapping(value="/mail")
public class MailTypeController {

	@Autowired
	private MailTypeService mailTypeService;
	
	@RequestMapping(value = "/saveFile", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void saveMailType( @RequestParam("file") MultipartFile multipartFile, @RequestParam("nom") String nom ){
		mailTypeService.save(nom , multipartFile);
	}
	
	@RequestMapping(value = "/saveMail", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void saveMailType( @RequestBody MailType mailType ){
		mailTypeService.saveMailWithoutFile(mailType);
	}
	
	
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MailType> getAll(){
		return mailTypeService.getAll();
	}
}
