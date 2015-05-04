package ppd.psa.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class PsaBox {
	@Id
	  private Long id;
	private String kfan;
	private String libelle;
	private String codeRddi;
	  @DBRef
	private List<Contact> contact;
	
//	  @DBRef
		private List<Etape> etapesDone;
	
	public PsaBox(){
		
	}

	public PsaBox(Long id, String kfan, String libelle, String codeRddi,
			List<Contact> contact, List<Etape> etapesDone) {
		super();
		this.id = id;
		this.kfan = kfan;
		this.libelle = libelle;
		this.codeRddi = codeRddi;
		this.contact = contact;
		this.etapesDone = etapesDone;
	}

	public List<Etape> getEtapesDone() {
		return etapesDone;
	}

	public void setEtapesDone(List<Etape> etapesDone) {
		this.etapesDone = etapesDone;
	}

	public String getKfan() {
		return kfan;
	}
	public void setKfan(String kfan) {
		this.kfan = kfan;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getCodeRddi() {
		return codeRddi;
	}
	public void setCodeRddi(String codeRddi) {
		this.codeRddi = codeRddi;
	}

	public List<Contact> getContact() {
		return contact;
	}

	public void setContact(List<Contact> contact) {
		this.contact = contact;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
