package org.ngarcia.webapp.ejb.service;

import jakarta.ejb.*;
import jakarta.enterprise.context.RequestScoped;

@Stateless
//@RequestScoped
//@Stateful
public class ServiceEjb {

   private int contador;

   //si el servicio es @Stateless es siempre la misma instancia. El contador se va incrementando
   //si el servicio es @Stateful son diferentes instancias estáticas. El contador se incrementa por
   //cada instancia. Esto es así porque el contexto es el del Request, eso puede cambiarse
   //si el servicio es @Stateful con @RequestScoped los services son iguales,
   //pero por cada request es un par nuevo por lo tanto el contador siempre imprime 1 y 2
   public String saludar(String nombre) {
      contador ++;
      System.out.println("imprimiendo ejb: " + this);
      System.out.println("contador: " + contador);
      return "Hola que tal " + nombre;
   }
}
