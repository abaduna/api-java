package com.academy.Cusromers.controlers;


import com.academy.Cusromers.entites.costumers;
import com.academy.Cusromers.services.CustomerServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CustomerControllers {
    @Autowired
   private CustomerServices service;

    @GetMapping("/customers/{id}")
    public Optional<costumers> getCustomers(@PathVariable Integer id){
      return service.getCustomers(id);

    }
    @GetMapping("/customers")
    public List<costumers> getAllCustomers(){
      return   service.getAllCustomers();
    }
    @PostMapping("/customers") //agregar cliente
    public void AddCustumers(@RequestBody costumers customers){
        service.AddCustumers(customers);
    }
    @DeleteMapping("/customers/{id}")
    public void removeCustomers(@PathVariable Integer id){
       service.removeCustomers(id);
    }
    @PutMapping("/customers/{id}") //agregar cliente
    public void update(@PathVariable Integer id,@RequestBody costumers updateCostumers ){
       // list.add(customers);
        service.update(id,updateCostumers);
    }

    @GetMapping("/customers/serch")
    @CrossOrigin(origins = "*")
    public List<costumers>  serchCustomers(@RequestParam(name = "email",required = false) String email){
       return  service.serchCustomers(email);


    }
}
