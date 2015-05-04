package ppd.psa.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.stereotype.Component;

import ppd.psa.util.SequenceDao;
@Component
public class Action {
	@Id
	  private Long id;
	@DBRef
	private PsaBox psaBox;
	@JsonProperty("encours")
	private Etape encours;
	@Autowired
	private SequenceDao sequenceDao;
	
	private static final String HOSTING_SEQ_KEY = "Action";


	public Action(){
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public PsaBox getPsaBox() {
		return psaBox;
	}


	public void setPsaBox(PsaBox psaBox) {
		this.psaBox = psaBox;
	}



	public Etape getEncours() {
		return encours;
	}


	public void setEncours(Etape encours) {
		this.encours = encours;
	}


	public Action(Long id, PsaBox psaBox, Etape encours) {
		super();
		this.id = id;
		this.psaBox = psaBox;
		this.encours = encours;
	}



	
}