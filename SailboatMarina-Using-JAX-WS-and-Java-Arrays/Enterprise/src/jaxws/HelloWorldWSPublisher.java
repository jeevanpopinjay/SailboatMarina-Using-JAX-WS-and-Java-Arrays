package jaxws;

import javax.xml.ws.Endpoint;  

public class HelloWorldWSPublisher {  
 public static void main(String[] args) {  
  Endpoint.publish("http://localhost:8005/WS/HelloWorld",new HelloWorldImpl());  
 }  
}  