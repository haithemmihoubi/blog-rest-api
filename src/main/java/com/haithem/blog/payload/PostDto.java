package com.haithem.blog.payload;

import lombok.Data;

@Data
public class PostDto {
    private Long id;
    private String title;
    private String description;
    private String content;
}
//Post data transfer object
// this class will be used to transfer data from the client to the server
// this class will contain the following fields:
// 1- id : the id of the post
// 2- title : the title of the post
// 3- description : the description of the post
// 4- content : the content of the post
// this class will contain the following annotations:
// 1- @Data : this annotation will generate getters and setters for all the fields

