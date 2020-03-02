package com.example.chatbot.demo.chatbot.Controller;


import com.example.chatbot.demo.chatbot.model.Response;
import com.example.chatbot.demo.chatbot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import sun.plugin2.message.Message;
import java.io.Serializable;
import java.util.LinkedHashMap;

@RestController
@RequestMapping("/dashboard")
public class Controller  {

  @Autowired
  private ProductService productService;

  @PostMapping
  public Response createCluster(@RequestBody Object obj) {
  String g= (String) ((LinkedHashMap)((LinkedHashMap)((LinkedHashMap) obj).get("queryResult")).get("parameters")).get("product");
System.out.println(g);
/*
    Response r = new Response();
    ArrayList<String> textlist=new ArrayList<>();
    textlist.add("hello");
    textlist.add("hii");
    Text text=new Text();
    text.setText(textlist);
    ArrayList<FulfillmentMessage> fulfillmentMessageList=new ArrayList<>();
    FulfillmentMessage full=new FulfillmentMessage();
    full.setText(text);
    fulfillmentMessageList.add(full);
    r.setFulfillmentMessages(fulfillmentMessageList);
   return r;*/

 return  productService.getproducts(g);
      }
    }

