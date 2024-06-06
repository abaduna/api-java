package com.academy.Cusromers.services;


import com.academy.Cusromers.entites.costumers;
import com.academy.Cusromers.repository.CustomerRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomersServiceImp implements CustomerServices {
    @Autowired
    private CustomerRepositori repositori;


    public Optional<costumers> getCustomers(Integer id){
        Optional<costumers>  costumers  = repositori.findAllById(id);
        if (costumers.isPresent()){
            return  costumers;
        }else {
            return  null;
        }
    }

    public List<costumers> getAllCustomers(){
        return  null;
    }

    public void AddCustumers(costumers customers){

    }

    public void removeCustomers(Integer id){

    }

    public void update(Integer id,costumers updateCostumers ){
        // list.add(customers);

    }


    public List<costumers>  serchCustomers( String email){
        return  null;
    }
}
