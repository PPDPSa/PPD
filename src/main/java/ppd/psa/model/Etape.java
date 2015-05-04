package ppd.psa.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.stereotype.Component;
import org.w3c.dom.ls.LSInput;

import ppd.psa.util.SequenceDao;

@Component
public class Etape {
	@Id
	private Long id;
	private String nom;
	@DBRef
	private List<MailType> mailType;
	@JsonProperty("priorite")
	private List<String> priorites;
	@Autowired
	private SequenceDao sequenceDao;

	private static final String HOSTING_SEQ_KEY = "Etape";

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Etape() {
		super();
	}

	public Etape(Long id, String nom, List<MailType> mailType,
			List<String> priorite) {
		super();
		this.id = sequenceDao.getNextSequenceId(HOSTING_SEQ_KEY);
		this.nom = nom;
		this.mailType = mailType;
		this.priorites = priorite;
	}

	public List<MailType> getMailType() {
		return mailType;
	}

	public void setMailType(List<MailType> mailType) {
		this.mailType = mailType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<String> getPriorites() {
		return priorites;
	}

	public void setPriorites(List<String> priorites) {
		this.priorites = priorites;
	}

}
