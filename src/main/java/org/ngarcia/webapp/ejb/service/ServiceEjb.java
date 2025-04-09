package org.ngarcia.webapp.ejb.service;

import jakarta.ejb.Stateless;

@Stateless
public class ServiceEjb {

   private int contador;

   public String saludar(String nombre) {
      contador ++;
      System.out.println("imprimiendo ejb: " + this);
      System.out.println("contador: " + contador);
      return "Hola que tal " + nombre;
   }
}
