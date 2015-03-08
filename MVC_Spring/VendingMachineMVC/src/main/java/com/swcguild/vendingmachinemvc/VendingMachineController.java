/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.vendingmachinemvc;

import com.swcguild.vendingmachinemvc.dao.VendingMachineDao;
import com.swcguild.vendingmachinemvc.dto.Change;
import com.swcguild.vendingmachinemvc.dto.Inventory;
import com.swcguild.vendingmachinemvc.logic.VendingMachineCalculator;
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

/**
 *
 * @author Helvinator
 */
@Controller
public class VendingMachineController
  {

    private VendingMachineDao dao;
    private VendingMachineCalculator calc;
    private Change change;

    @Inject
    public VendingMachineController(VendingMachineDao dao, VendingMachineCalculator calc) {
        this.dao = dao;
        this.calc = calc;
    }

    @RequestMapping(value = {"/", "home", "/index"}, method = RequestMethod.GET)
    public String sayHi(Map<String, Object> model) {
        model.put("message", "Hello from the Controller Man");
        return "home";
    }

    @RequestMapping(value = "/inventory", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Inventory createInventory(@RequestBody Inventory inventory) {
        dao.addInventory(inventory);
        return inventory;
    }

    @RequestMapping(value = "inventory", method = RequestMethod.GET)
    @ResponseBody
    public List<Inventory> getAllInventory() {
        return dao.getAllInventory();
    }

    @RequestMapping(value = "/inventory/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Inventory getInventory(@PathVariable("id") int id) {
        return dao.getInventoryById(id);
    }

    @RequestMapping(value = "/inventory/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putInventory(@PathVariable("id") int id, @RequestBody Inventory inventory) {
        inventory.setInventoryId(id);
        dao.updateInventory(inventory);
    }

    @RequestMapping(value = "/inventory/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInventory(@PathVariable("id") int id) {
        dao.removeInventory(id);
    }

    @RequestMapping(value = "/change", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void change() {
        
    }
    
    
    @RequestMapping(value = "/change/{price}/{money}", method = RequestMethod.POST)
   // @ResponseStatus(HttpStatus.NO_CONTENT)
   @ResponseBody
    public String changeReturn(@PathVariable("money") double money, @PathVariable("price") double price) {
    
        int moneyBack= calc.change(money, price);
       return calc.changeReturn(moneyBack);
    }

   

  }
