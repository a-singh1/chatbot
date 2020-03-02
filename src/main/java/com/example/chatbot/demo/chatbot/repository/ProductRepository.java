package com.example.chatbot.demo.chatbot.repository;

import java.util.List;
import com.example.chatbot.demo.chatbot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


public interface ProductRepository extends JpaRepository<Product,Long> {

  List<Product> findAll();

  List<Product> findByCategory(String g);

/* // @Query("SELECT DISTINCT p.name FROM Product p ")

  @Query(value = "select  a.category from product a "
      , nativeQuery = true)
  List<String> findNonReferencedNames();


  List<Product> findDistinctByCategory();*/
}
