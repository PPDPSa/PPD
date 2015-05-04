package ppd.psa.model;

import java.util.Arrays;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.web.multipart.MultipartFile;

public class MailType {
	@Id
	  private Long id;
	private String nom;
	private String objet;
	private String corpText;
	private List<String> destinataires;
	private byte [] pieceJointe;
	
	
	public MailType(){
		
		
		
		
	}


	
	public MailType(Long id, String nom, String objet, String corpText,
			List<String> destinataires, byte[] pieceJointe) {
		super();
		this.id = id;
		this.nom = nom;
		this.objet = objet;
		this.corpText = corpText;
		this.destinataires = destinataires;
		this.pieceJointe = pieceJointe;
	}



	public String getObjet() {
		return objet;
	}



	public void setObjet(String objet) {
		this.objet = objet;
	}

	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getCorpText() {
		return corpText;
	}


	public List<String> getDestinataires() {
		return destinataires;
	}



	public void setDestinataires(List<String> destinataires) {
		this.destinataires = destinataires;
	}



	public void setCorpText(String corpText) {
		this.corpText = corpText;
	}




	


	public byte[] getPieceJointe() {
		return pieceJointe;
	}


	public void setPieceJointe(byte[] pieceJointe) {
		this.pieceJointe = pieceJointe;
	}


	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "MailType [id=" + id + ", nom=" + nom + ", objet=" + objet
				+ ", corpText=" + corpText + ", destinataires=" + destinataires
				+ ", pieceJointe=" + Arrays.toString(pieceJointe) + "]";
	}



	
	

}
