package com.example.chatbot.demo.chatbot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private  long id;
  @Column(name = "category")
  private String category;
  @Column(name = "material")
  private String material;
  @Column(name = "price")
  private String price;
}
