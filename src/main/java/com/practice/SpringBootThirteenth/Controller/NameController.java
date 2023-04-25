package com.practice.SpringBootThirteenth.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.SpringBootThirteenth.Entity.Name;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class NameController {
	
	 @Autowired
	    private SessionFactory sessionFactory;

    @PostMapping("/submit-name")
    public String submitName(@RequestParam("name") String name, Model model) {
        System.out.println("Name submitted : "+name);
        Name newName = new Name(name);
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(newName);
        session.getTransaction().commit();
        model.addAttribute("name", name);
        return "index.html";
    }
}


