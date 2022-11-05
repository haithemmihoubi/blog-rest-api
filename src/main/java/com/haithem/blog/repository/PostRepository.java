package com.haithem.blog.repository;

import com.haithem.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
// this is the interface that extends the JpaRepository interface
// and it will be used to perform CRUD operations on the Post entity
// this will contain all the methods that will be used to perform CRUD operations on the Post entity
// we dont need to implement this interface because it is already implemented by the JpaRepository interface
// we just need to extend it
//  it contains findAll(), findById(), save(), deleteById() methods
//  we can also add our own methods to this interface
// it contains the following methods:
// 1- findAll() : returns all the records of the entity
// 2- findById() : returns the record of the entity with the specified id
// 3- save() : saves the record of the entity
// 4- deleteById() : deletes the record of the entity with the specified id
// 5- count() : returns the number of records of the entity
// 6- existsById() : returns true if the record of the entity with the specified id exists
// 7- deleteAll() : deletes all the records of the entity
// 8- deleteAll(Iterable<? extends T> entities) : deletes all the records of the entity that are in the specified iterable
// 9- delete(T entity) : deletes the specified record of the entity
// 10- deleteAll() : deletes all the records of the entity
// 11- findAllById(Iterable<ID> ids) : returns all the records of the entity that are in the specified iterable
// 12- flush() : flushes all pending changes to the database
// 13- getOne(ID id) : returns a reference to the entity with the specified id
// 14- saveAll(Iterable<T> entities) : saves all the records of the entity that are in the specified iterable
// 15- saveAndFlush(T entity) : saves the specified record of the entity and flushes changes instantly

public interface PostRepository extends JpaRepository<Post, Long> {

}