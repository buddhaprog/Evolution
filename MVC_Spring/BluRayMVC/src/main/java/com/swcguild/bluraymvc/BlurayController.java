package com.swcguild.bluraymvc;

import com.swcguild.bluraymvc.dao.BlurayDao;
import com.swcguild.bluraymvc.dto.Bluray;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class BlurayController
  {

    private BlurayDao dao;

    @Inject
    public BlurayController(BlurayDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = {"/", "home", "/index"}, method = RequestMethod.GET)
    public String sayHi(Map<String, Object> model) {
        model.put("message", "Hello from the controller");
        return "home";
    }
    @RequestMapping(value="/bluray", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody public Bluray createBluray(@RequestBody Bluray bluray){
    dao.addBluray(bluray);
    return bluray;
        
    }
    @RequestMapping(value="blurays", method=RequestMethod.GET)
    @ResponseBody
    public List<Bluray> getAllBlurays(){
    return dao.getAllBlurays();
    }
    
    @RequestMapping(value="/bluray/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Bluray getBluray(@PathVariable("id") int id){
    return dao.getBlurayById(id);
    }
    @RequestMapping(value="/bluray/{id}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putBluray(@PathVariable("id") int id, @RequestBody Bluray bluray){
    bluray.setCounterId(id);
    dao.updateBluray(bluray);
    }
    @RequestMapping(value="/bluray/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBluray(@PathVariable("id")int id){
    dao.removeBluray(id);
    
    }
  }
