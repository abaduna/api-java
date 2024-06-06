package com.academy.Cusromers.services;


import com.academy.Cusromers.entites.costumers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomersServiceImp implements CustomerServices {
    private List<costumers> list = new ArrayList<>();
    public CustomersServiceImp(){
        costumers c = new costumers();
        c.setId(1);
        c.setFirsname("Arthur");
        c.setLastname("baduna");
        c.setAdress("sdfjhfsda");
        c.setEmail("a@gmail.com");
        list.add(c);

        costumers d = new costumers();
        d.setId(2);
        d.setFirsname("luscas");
        d.setLastname("moy");
        d.setAdress("siempre viva 1234");
        d.setEmail("lucas@gmail.com");
        list.add(d);
        /*
        list.stream().filter(d => d.getAdress().contains("hola"))
        expresiones landa buscar
         */
    }

    public costumers getCustomers(Integer id){
        for (costumers customers:list) {
            if (customers.getId() == id) {
                return  customers;
            }
        }
        return  null    ;
    }

    public List<costumers> getAllCustomers(){
        return  list;
    }

    public void AddCustumers(costumers customers){
        list.add(customers);
    }

    public void removeCustomers(Integer id){
        for (costumers customers:list) {
            if (customers.getId() == id) {
                list.remove(customers);
                break;
            }
        }
    }

    public void update(Integer id,costumers updateCostumers ){
        // list.add(customers);
        for (costumers c:list) {
            if (c.getId() == id) {
                list.remove(c);
                updateCostumers.setId(id);
                list.add(updateCostumers);
                break;
            }
        }
    }


    public List<costumers>  serchCustomers( String email){
        List<costumers> listSerch = new ArrayList<>();
        for (costumers customers:list) {
            if (customers.getEmail().contains(email)) {
                listSerch.add(customers);

            }

        }

        return  listSerch;
    }
}
