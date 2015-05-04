package ppd.psa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ppd.psa.model.PsaBox;
import ppd.psa.service.PsaBoxService;

@Controller
@RequestMapping(value="/psabox")
public class PsaBoxController {

	@Autowired
	private PsaBoxService psaBoxService;
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void SavePsaBox(@RequestBody PsaBox psaBox){
		psaBoxService.savePsaBox(psaBox);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void modifyPsaBox(@RequestBody PsaBox psaBox){
		psaBoxService.savePsaBox(psaBox);
	}
	
	
	
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<PsaBox> getAll(){
    	return psaBoxService.getAll();
	}
}
