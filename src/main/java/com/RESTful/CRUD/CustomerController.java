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

import org.springframework.http.MediaType;

@RestController
class CustomerController{
    @Autowired
    private CustomerRepository repository;

    /*
    ######################################################
        REQUEST BODY:
            {
                "customerId": customer_id,
                "customerName": customer_name,
                "amountSpent": amount_spent,
                "purchaseDate": purchase_date
            }

        SAMPLE:
            {
                "customerId": 4,
                "customerName": "Rose",
                "amountSpent": "110",
                "purchaseDate": "2022-10-04"
            }
    ######################################################
    */

    @PostMapping("/payload")
    public ResponseEntity<Void> createCustomer(@RequestBody Customer customer){
        Integer id = customer.getCustomerId();
        if (id != null){
            Optional<Customer> optionalEntity = repository.findById(id);

            if (optionalEntity.isPresent()){
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
            repository.save(customer);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /*
    ######################################################
        REQUEST BODY:
            {
                "customerId": id_value
            }
        id_value = 1, 2, 3 are preloaded for testing 
        SAMPLE:
            {
                "customerId": 1
            }
    ######################################################
    */

    @GetMapping("/payload")
    public ResponseEntity<?> getAmountSpent(@NonNull @RequestBody InputPayload inputPayload){
        Integer id = inputPayload.getCustomerId();  
        if (id != null){ 
            Optional<Customer> optionalEntity = repository.findById(id);

            if (optionalEntity.isPresent()){
                Customer response = optionalEntity.get();
                Double amountSpent = response.getAmountSpent();
                return new ResponseEntity<>(amountSpent, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /*
    ######################################################
        REQUEST BODY:
            {
                "customerId": customer_id,
                "customerName": customer_name,
                "amountSpent": amount_spent,
                "purchaseDate": purchase_date
            }

        SAMPLE:
            {
                "customerId": 4,
                "customerName": "Rose",
                "amountSpent": "55.40",
                "purchaseDate": "2022-10-04"
            }
    ######################################################
    */

    @PutMapping(value = "/payload", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer){
        Integer id = customer.getCustomerId();
        if (id != null){
            Optional<Customer> optionalEntity = repository.findById(id);

            if (optionalEntity.isPresent()){
                Customer response = optionalEntity.get();
                if (customer.getCustomerName() != null) {
                    response.setCustomerName(customer.getCustomerName());
                }
                if (customer.getAmountSpent() != null) {
                    response.setAmountSpent(customer.getAmountSpent());
                }
                if (customer.getPurchaseDate() != null) {
                    response.setPurchaseDate(customer.getPurchaseDate());
                }
                repository.save(response);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /*
    ######################################################
        REQUEST BODY:
            {
                "customerId": id_value
            }
        id_value = 1, 2, 3 are preloaded for testing 
        SAMPLE:
            {
                "customerId": 1
            }
    ######################################################
    */

    @DeleteMapping(value = "/payload", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteCustomer(@RequestBody InputPayload inputPayload){
        Integer id = inputPayload.getCustomerId();
        if (id != null){
            Optional<Customer> optionalEntity = repository.findById(id);
            if (optionalEntity.isPresent()){
                repository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}