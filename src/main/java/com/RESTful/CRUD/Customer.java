package com.RESTful.CRUD;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table
class Customer{
    // private @Id @GeneratedValue Long customerId;
    private @Id Integer customerId;
    String customerName;
    private Double amountSpent;
    private LocalDate purchaseDate;

    Customer() {} // empty constructor

    public Customer(Integer customerId, String customerName, Double amountSpent, LocalDate purchaseDate){
        this.customerId = customerId;
        this.customerName = customerName;
        this.amountSpent = amountSpent;
        this.purchaseDate = purchaseDate;
    }

    public Integer getCustomerId(){
        return this.customerId;
    }

    public String getCustomerName(){
        return this.customerName;
    }

    public Double getAmountSpent(){
        return this.amountSpent;
    }

    public LocalDate getPurchaseDate(){
        return this.purchaseDate;
    }

    public void setCustomerId(Integer customerId){
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }

    public void setAmountSpent (Double amountSpent){
        this.amountSpent = amountSpent;
    }

    public void setPurchaseDate (LocalDate purchaseDate){
        this.purchaseDate = purchaseDate;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.customerId, this.customerName, this.amountSpent, this.purchaseDate);
    }

    @Override
    public String toString(){
        return "Customer{" + "CustomerId=" + this.customerId + ", name='" + this.customerName + '\'' + ", amountSpent='" + this.amountSpent + '\'' + ", date='" + this.purchaseDate + '}';
    }
}