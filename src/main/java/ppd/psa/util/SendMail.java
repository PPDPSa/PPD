package ppd.psa.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ppd.psa.model.Contact;
import ppd.psa.model.MailType;
import ppd.psa.model.PsaBox;

@Service
public class SendMail {

	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
	
//	@Autowired
//	private BASE64DecodedMultipartFile base64DecodedMultipartFile;

//	public static void main(String args[]) throws AddressException, MessagingException {
//		generateAndSendEmail();
//		System.out.println("\n\n ===> Your Java Program has just sent an Email successfully. Check your email..");
//	}

    public static File stream2file (InputStream in)  {
        File tempFile;
//		try {
//			tempFile = File.createTempFile("test",".tmp");
//        tempFile.deleteOnExit();
//        try (FileOutputStream out = new FileOutputStream(tempFile)) {
//            IOUtils.copy(in, out);
//        }
//        return tempFile;
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return null;
    }
	
	public  void generateAndSendEmail(MailType mailType, PsaBox psaBox) {
		try {
	//Step1		
//			base64DecodedMultipartFile = new BASE64DecodedMultipartFile(mailType.getPieceJointe());
			   
//			File file =  stream2file(base64DecodedMultipartFile.getInputStream());
			File file = null;
		        FileDataSource datasource1 = new FileDataSource(file);
		        DataHandler handler1 = new DataHandler(datasource1);
		Transport transport = null;
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("Mail Server Properties have been setup successfully..");

		System.out.println(mailType);
		System.out.println(mailType.getObjet());
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.setSubject(mailType.getObjet());
		String emailBody = mailType.getCorpText();
		generateMailMessage.setContent(emailBody, "text/html");
	//Step2
		for (Contact contact : psaBox.getContact()){
		System.out.println("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage.setFrom(new InternetAddress(contact.getEmailContact()));
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(contact.getEmailContact()));
		System.out.println("Mail Session has been created successfully..");
	//Step3		
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		transport = getMailSession.getTransport("smtp");
		
		transport.connect("smtp.gmail.com", "ppdpsa@gmail.com", "Niroshan1234");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		}
		transport.close();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}