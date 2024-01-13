package com.RESTful.CRUD;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.lang.NonNull;

@RestController
class CustomerController{
    @Autowired
    private CustomerRepository repository;

    /*
    ######################################################
        REQUEST BODY:
            {
                "customerName": customer_name,
                "amountSpent": amount_spent,
                "purchaseDate": purchase_date
            }

        SAMPLE:
            {
                "customerName": "Rose",
                "amountSpent": "110",
                "purchaseDate": "2022-10-04"
            }
    ######################################################
    */

    @PostMapping("/payload")
    public ResponseEntity<Void> createEntry(@RequestBody Customer customer){
        if (customer != null){
            repository.save(customer);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /*
    ######################################################
        REQUEST BODY:
            {
                "id": id_value
            }
        id_value = 1, 2, 3 are preloaded for testing 
        SAMPLE: {"id": 1}
    ######################################################
    */

    @GetMapping("/payload")
    public ResponseEntity<?> getAmountSpent(@NonNull @RequestBody InputPayload inputPayload){
        Long id = inputPayload.getId();   

        // if (id == null || id.toString().trim().isEmpty()){
        //     String errorMessage = "'id' Cannot be null or blank";
        //     return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        // }

        Optional<Customer> optionalEntity = repository.findById(id);

        if (optionalEntity.isPresent()){
            Customer response = optionalEntity.get();
            Long amountSpent = response.getAmountSpent();
            return new ResponseEntity<>(amountSpent, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}