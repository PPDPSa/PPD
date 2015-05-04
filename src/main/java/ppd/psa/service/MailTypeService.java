package ppd.psa.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import ppd.psa.dao.MailTypeDao;
import ppd.psa.model.MailType;

@Component
public class MailTypeService {

	@Autowired
	private MailTypeDao mailTypeDao;
	
	
	public void saveMailWithoutFile(MailType mailType){
		mailTypeDao.saveMailType(mailType);
	}
	
	public void save(String nom, MultipartFile file) {
		byte[] bFile;
		MailType mailType =  mailTypeDao.findByName(nom);
	if(file != null){
		try {
			bFile = file.getBytes();
			mailType.setPieceJointe(bFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		mailTypeDao.saveMailType(mailType);	
	}
	
	
	public List<MailType> getAll(){
	 return	mailTypeDao.getAll();
	}
}
