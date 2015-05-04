package ppd.psa.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;


public class Contact {
	@Id
	  private Long id;
	private String nomContact;
	private String numeroTelContact;
	private String emailContact;
	private String login;
	private String mdp;
	private String droit;
			
	public Contact(){
		
	}
	
	public Contact(String nomContact, String numeroTelContact,
			String emailContact, String login, String mdp, String droit) {
		super();
		this.nomContact = nomContact;
		this.numeroTelContact = numeroTelContact;
		this.emailContact = emailContact;
		this.login = login;
		this.mdp = mdp;
		this.droit = droit;
	}
	public String getDroit() {
		return droit;
	}
	public void setDroit(String droit) {
		this.droit = droit;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getNomContact() {
		return nomContact;
	}
	public void setNomContact(String nomContact) {
		this.nomContact = nomContact;
	}
	public String getNumeroTelContact() {
		return numeroTelContact;
	}
	public void setNumeroTelContact(String numeroTelContact) {
		this.numeroTelContact = numeroTelContact;
	}
	public String getEmailContact() {
		return emailContact;
	}
	public void setEmailContact(String emailContact) {
		this.emailContact = emailContact;
	}
	@Override
	public String toString() {
		return "Contact [nomContact=" + nomContact + ", numeroTelContact="
				+ numeroTelContact + ", emailContact=" + emailContact
				+ ", login=" + login + ", mdp=" + mdp + ", droit=" + droit
				+ "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
