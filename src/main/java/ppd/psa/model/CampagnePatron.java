package ppd.psa.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class CampagnePatron {

	private String nom;
	private List<Etape> etapes;
	@JsonProperty("psaboxs")
	private List<PsaBox> psaboxs;
	
	public CampagnePatron(){
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Etape> getEtapes() {
		return etapes;
	}

	public void setEtapes(List<Etape> etapes) {
		this.etapes = etapes;
	}

	public List<PsaBox> getPsaBoxs() {
		return psaboxs;
	}

	public void setPsaBoxs(List<PsaBox> psaBoxs) {
		this.psaboxs = psaBoxs;
	}

	public CampagnePatron(String nom, List<Etape> etapes, List<PsaBox> psaboxs) {
		super();
		this.nom = nom;
		this.etapes = etapes;
		this.psaboxs = psaboxs;
	}
	
}
