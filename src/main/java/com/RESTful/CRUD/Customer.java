package com.RESTful.CRUD;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table
class Customer{
    private @Id @GeneratedValue Long customerId;
    String customerName;
    private Long amountSpent;
    private LocalDate purchaseDate;

    Customer() {} // empty constructor

    public Customer(String customerName, Long amountSpent, LocalDate purchaseDate){
        this.customerName = customerName;
        this.amountSpent = amountSpent;
        this.purchaseDate = purchaseDate;
    }

    public String getCustomer() {
        return this.customerName;
    }

    public Long getAmountSpent() {
        return this.amountSpent;
    }

    public LocalDate getPurchaseDate() {
        return this.purchaseDate;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setAmountSpent (Long amountSpent) {
        this.amountSpent = amountSpent;
    }

    public void setPurchaseDate (LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.customerId, this.customerName, this.amountSpent, this.purchaseDate);
    }

    @Override
    public String toString() {
        return "Customer{" + "CustomerId=" + this.customerId + ", name='" + this.customerName + '\'' + ", amountSpent='" + this.amountSpent + '\'' + ", date='" + this.purchaseDate + '}';
    }
}