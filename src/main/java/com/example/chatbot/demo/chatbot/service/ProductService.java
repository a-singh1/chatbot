package com.example.chatbot.demo.chatbot.service;

import com.example.chatbot.demo.chatbot.model.Response;
import org.springframework.stereotype.Service;


public interface ProductService {
  Response getproducts(String g);
}
