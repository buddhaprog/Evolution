
package com.swcguild.contactlistmvc.controller;

import com.swcguild.contactlistmvc.dao.ContactDao;
import com.swcguild.contactlistmvc.dto.Contact;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Helvinator
 */
@Controller
public class HomeControllerNoAjax {
    
    private ContactDao dao;
    
    @Inject
    public HomeControllerNoAjax(ContactDao dao) {
        this.dao = dao;
    }
    
    @RequestMapping(value="/displayContactListNoAjax", method=RequestMethod.GET)
    public String displayContactListNoAjax(Model model) {
        
        List<Contact> cList = dao.getAllContacts();
        
        model.addAttribute("contactList", cList);
        
        return "displayContactListNoAjax";
    }
    
    @RequestMapping(value="/displayNewContactFormNoAjax", method=RequestMethod.GET)
    public String displayNewContactFormNoAjax() {
        return "newContactFormNoAjax";
    }
    
    @RequestMapping(value="addNewContactNoAjax", method=RequestMethod.POST)
    public String addNewContactNoAjax(HttpServletRequest req) {
        
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String company = req.getParameter("company");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        
        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setCompany(company);
        contact.setEmail(email);
        contact.setPhone(phone);
        
        dao.addContact(contact);
        
        return "redirect:displayContactListNoAjax";
    }
    
    @RequestMapping(value="/deleteContactNoAjax", method=RequestMethod.GET)
    public String deleteContactNoAjax(HttpServletRequest req) {
        int contactId = Integer.parseInt(req.getParameter("contactId"));
        
        dao.removeContact(contactId);
        
        return "redirect:displayContactListNoAjax";
    }
    
    @RequestMapping(value="/displayEditContactFormNoAjax", method=RequestMethod.GET)
    public String displayEditContactFormNoAjax(HttpServletRequest req, Model model) {
        int contactId = Integer.parseInt(req.getParameter("contactId"));
        
        Contact contact = dao.getContactById(contactId);
        
        model.addAttribute("contact", contact);
        
        return "editContactFormNoAjax";
    }
    
    @RequestMapping(value="editContactNoAjax", method=RequestMethod.POST)
    public String editContactNoAjax(@ModelAttribute("contact") Contact contact) {
        dao.updateContact(contact);
        return "redirect:displayContactListNoAjax";
    }

}
