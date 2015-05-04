package ppd.psa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ppd.psa.dao.EtapeDao;
import ppd.psa.model.Etape;


@Controller
@RequestMapping(value="/etape")
public class EtapeController {

	@Autowired
	private EtapeDao etapeDao;
	
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Etape> getAll(){
		return etapeDao.getAll();
	}
}
