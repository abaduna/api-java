package com.academy.Cusromers.services;

import com.academy.Cusromers.entites.costumers;


import java.util.List;

public interface CustomerServices {

     costumers getCustomers(Integer id);

      List<costumers> getAllCustomers();

      void AddCustumers(costumers customers);

      void removeCustomers(Integer id);

      void update(Integer id,costumers updateCostumers );


      List<costumers>  serchCustomers( String email);
      /*
      default void hacerAlgo(){
          System.out.println("Hacer qalgo");
      }*/
}
