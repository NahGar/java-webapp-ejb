package org.ngarcia.webapp.ejb.controllers;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.ngarcia.webapp.ejb.service.ServiceEjb;

import java.io.IOException;

@WebServlet("/index")
public class EjemploServlet extends HttpServlet {

   @EJB
   private ServiceEjb service;

   @EJB
   private ServiceEjb service2;

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp)
           throws ServletException, IOException {

      System.out.println("service = service2:" +service.equals(service2));
      req.setAttribute("saludo",service.saludar("Carlos"));
      req.setAttribute("saludo2",service2.saludar("Roberto"));
      getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
   }
}
