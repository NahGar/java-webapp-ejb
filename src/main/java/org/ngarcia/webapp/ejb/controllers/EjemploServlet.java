package org.ngarcia.webapp.ejb.controllers;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.ngarcia.webapp.ejb.service.ServiceEjb;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;

@WebServlet("/index")
public class EjemploServlet extends HttpServlet {

   //si se inyecta con @EJB se ignora el contexto @RequestScoped, @SessionScoped, etc
   //@EJB
   //@Inject
   //private ServiceEjb service;

   //@EJB
   //@Inject
   //private ServiceEjb service2;

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp)
           throws ServletException, IOException {

      //si el servicio es @Stateless es siempre la misma instancia.
      //si el servicio es @Stateful los services son estáticos pero diferentes
      //si el servicio es @Stateful con @RequestScoped los services son iguales,
      //pero por cada request es un par nuevo

      //Equivale a los @Inyect
      ServiceEjb service = null;
      ServiceEjb service2 = null;

      try {
         InitialContext ctx = new InitialContext();
         service = (ServiceEjb) ctx.lookup("java:global/webapp-ejb/ServiceEjb!org.ngarcia.webapp.ejb.service.ServiceEjb");
         service2 = (ServiceEjb) ctx.lookup("java:global/webapp-ejb/ServiceEjb!org.ngarcia.webapp.ejb.service.ServiceEjb");
      } catch (NamingException e) {
         e.printStackTrace();
      }

      System.out.println("service = service2:" +service.equals(service2));
      req.setAttribute("saludo",service.saludar("Carlos"));
      req.setAttribute("saludo2",service2.saludar("Roberto"));
      getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
   }
}
