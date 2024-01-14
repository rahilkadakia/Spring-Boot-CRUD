package com.RESTful.CRUD;

public class InputPayload {
    private Integer customerId;

    public InputPayload() {}
    public InputPayload(Integer customerId){
        this.customerId = customerId;
    }
    
    public Integer getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}