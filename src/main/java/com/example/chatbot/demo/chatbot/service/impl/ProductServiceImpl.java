package com.example.chatbot.demo.chatbot.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import com.example.chatbot.demo.chatbot.model.FulfillmentMessage;
import com.example.chatbot.demo.chatbot.model.Product;
import com.example.chatbot.demo.chatbot.model.Response;
import com.example.chatbot.demo.chatbot.model.Text;
import com.example.chatbot.demo.chatbot.repository.ProductRepository;
import com.example.chatbot.demo.chatbot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Override
  public Response getproducts(String g) {

    if (g.equalsIgnoreCase("something")) {
      List<Product> li = productRepository.findAll();


     // List<String> linew=productRepository.findNonReferencedNames();
      HashSet<String> hs=new HashSet<>();
      List<String> line = li.stream().map(product -> product.getCategory()).collect(Collectors.toList());
      for (String product:line) {
hs.add(product);
      }
    List<String> linew=new ArrayList<>();
      for (String i : hs)
      {
        linew.add(i);
      }
      Response r = new Response();
      Text text = new Text();
      text.setText(linew);
      ArrayList<FulfillmentMessage> fulfillmentMessageList = new ArrayList<>();
      FulfillmentMessage full = new FulfillmentMessage();
      full.setText(text);
      fulfillmentMessageList.add(full);
      r.setFulfillmentMessages(fulfillmentMessageList);
      return r;
    }

    else if(g.equalsIgnoreCase("books"))
    {
      final String uri = "http://localhost:8082/getproductdetails?string="+g;

      RestTemplate restTemplate = new RestTemplate();
      String result = restTemplate.getForObject(uri, String.class);

      System.out.println(result);

      return null;

    }


    else {
      List<Product> li = productRepository.findByCategory(g);
      List<String> linew = li.stream().map(product -> product.getMaterial()).collect(Collectors.toList());
      Response r = new Response();
      Text text = new Text();
      text.setText(linew);
      ArrayList<FulfillmentMessage> fulfillmentMessageList = new ArrayList<>();
      FulfillmentMessage full = new FulfillmentMessage();
      full.setText(text);
      fulfillmentMessageList.add(full);
      r.setFulfillmentMessages(fulfillmentMessageList);
      return r;

    }
  }
}