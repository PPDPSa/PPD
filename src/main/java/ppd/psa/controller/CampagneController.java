package ppd.psa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ppd.psa.dao.ActionDao;
import ppd.psa.model.Action;
import ppd.psa.model.Campagne;
import ppd.psa.model.CampagnePatron;
import ppd.psa.model.Etape;
import ppd.psa.model.PsaBox;
import ppd.psa.service.CampagneService;
import ppd.psa.util.SequenceDao;

@Controller
@RequestMapping(value="/campagne")
public class CampagneController {

	@Autowired
	private CampagneService campagneService;
	
	@Autowired
	private SequenceDao sequenceDao;
	
	@Autowired
	private ActionDao actionDao;
	
	private static final String HOSTING_SEQ_KEY = "Action";
	
	private static final String HOSTING_SEQ_KEY2 = "Etape";
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void saveCampagne(@RequestBody CampagnePatron patron ){
		List<Action> actions = new ArrayList<Action>();
		Action action = null;
		Campagne campagne = new Campagne();
		
		campagne.setNom(patron.getNom());
		List<Etape> etapes = new ArrayList<Etape>();
		for(Etape etape : patron.getEtapes()){
			etape.setId(sequenceDao.getNextSequenceId(HOSTING_SEQ_KEY2));
			etapes.add(etape);
		}
		patron.setEtapes(etapes);;
		campagne.setEtapes(patron.getEtapes());
		for (PsaBox psaBox : patron.getPsaBoxs()){
			action = new Action(sequenceDao.getNextSequenceId(HOSTING_SEQ_KEY),psaBox,patron.getEtapes().get(0));
			actionDao.saveAction(action);
			actions.add(action);
		}
		campagne.setActions(actions);
		campagneService.saveCampagne(campagne);
	}
	
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Campagne> getAll(){
		return campagneService.getAll();
	}
    
    
}
