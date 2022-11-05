package com.haithem.blog.exception;

public class ResourceNotFoundException extends RuntimeException {
    private String resourceName;
    private String fieldName;
    private String fieldValue;




    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}

// creating a custom execption class that extends the RuntimeException class
// this class will be used to throw an exception when a resource is not found
// this class will contain the following fields:
// 1- resourceName : the name of the resource that is not found
// 2- fieldName : the name of the field that is not found
// 3- fieldValue : the value of the field that is not found
// this class will contain the following constructor:
// 1- ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) : this constructor will take the name of the resource, the name of the field and the value of the field as parameters and will call the super constructor of the RuntimeException class and will pass it a message that contains the name of the resource, the name of the field and the value of the field