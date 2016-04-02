package com.bantignel.boutique;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bantignel.boutique.dao.EmployeDAO;
import com.bantignel.boutique.dao.impl.EmployeDAOImpl;
import com.bantignel.boutique.model.Client;
import com.bantignel.boutique.model.Employe;
import com.bantignel.boutique.service.ClientService;
import com.bantignel.boutique.service.EmployeService;

public class Test {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/root-context.xml");
	    EmployeDAO employeDAO = context.getBean(EmployeDAOImpl.class);
	    ClientService service = context.getBean(ClientService.class);
	    Client emp = new Client();
	    emp.setId(11);
	    emp.setNom("Barry");
	    emp.setPrenom("Mamadou");
	    emp.setAdresse("13 rue Franz Heller 35700 Rennes");
	    emp.setTelephone("1234567890");
	    emp.setEmail("email@google.com");
	    service.edit(emp);
	    emp = new Client();
	    emp.setNom("Albert");
	    emp.setPrenom("soumah");
	    emp.setAdresse("13 rue Charles des gaules 69000 Lyon");
	    emp.setTelephone("123434521");
	    emp.setEmail("albert@yahoo.com");
	    //service.edit(emp);
	   /** emp.setLogin("mbarry");
	    emp.setEmail("password");
	    
	    emp.setDateEmbauche("01-01-2016");
	    emp.setSalaire(5000);
	   
	    service.add(emp);
	    emp = service.get(1);
	    System.out.println(emp.getNom());
	    */
        
	}
}
