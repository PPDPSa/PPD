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

import ppd.psa.model.Action;
import ppd.psa.service.ActionService;

@Controller
@RequestMapping(value="/action")
public class ActionController {

	@Autowired
	private ActionService actionService;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void saveAction(@RequestBody Action action){
		actionService.saveAction(action);
	}
	 
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Action> getAll(){
		return actionService.getAll();
	}
	
}
