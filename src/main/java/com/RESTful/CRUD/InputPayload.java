package com.RESTful.CRUD;

public class InputPayload {
    private Long id;

    public InputPayload() {}
    public InputPayload(Long id){
        this.id = id;
    }
    
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}