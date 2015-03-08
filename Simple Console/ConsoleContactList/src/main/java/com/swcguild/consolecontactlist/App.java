/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.consolecontactlist;

import com.swcguild.consolecontactlist.controller.ContactController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Helvinator
 */
public class App {
    public static void main(String[] args) {
        
    
    ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
    ContactController controller=ctx.getBean("contactController", ContactController.class);
    controller.run();
    }
}
