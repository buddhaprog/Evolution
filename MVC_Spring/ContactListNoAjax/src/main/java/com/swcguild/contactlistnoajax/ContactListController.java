/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.contactlistnoajax;

import com.swcguild.contactlistnoajax.dao.ContactListDao;
import com.swcguild.contactlistnoajax.dto.Contact;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Helvinator
 */
@Controller
public class ContactListController {

    private final ContactListDao dao;
   @Inject
    public ContactListController(ContactListDao dao){
    this.dao= dao;
    
    }
    @RequestMapping(value="contactList", method=RequestMethod.GET)
    public String displayContactList(Model model){
    List<Contact> cList= dao.getAllContacts();
    model.addAttribute("contactList", cList);
    return "displayContactList";
    }
    
    //since we are not suing the Model, we don't need spring to hand it to us.
    // the tutorial takes a model parameter- which is fine but we don't use it
    //so it is not necessary.
    //name of method, request mapping/url, view component do not have to be 
    //named the same but they can be.
    @RequestMapping(value="/displayNewContactForm", method=RequestMethod.GET)
    public String displayNewContactForm(){
    return "addContactForm";
    
    }
    
    
}
