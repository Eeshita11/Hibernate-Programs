package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Address;
import com.example.entity.Employee;


public class App 
{
    public static void main( String[] args )
    {
    	  System.out.println("Connection started");
          Configuration cfg=new Configuration();
          cfg.configure("hibernate.cfg.xml");
          SessionFactory factory=cfg.buildSessionFactory();
          Session session=factory.openSession();
          try
          {
        	  
        	 Employee e1=new Employee();
        	 e1.setName("Ram");
        	 e1.setSalary(12000);
        	 
        	 Address a1=new Address();
        	 a1.setStreet("gurudwar");
        	 
        	 e1.setAddress(a1);
        	 a1.setEmployee(e1);
        	 
        	 session.beginTransaction();
        	 session.save(e1);
        	 session.getTransaction().commit();
        	 
          }
          catch(Exception e)
          {
        	  e.printStackTrace();
          }
          finally
          {
        	  session.close();
        	  factory.close();
          }
        

    }
}
