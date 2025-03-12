package net.javaguides.springboot.controllers;

//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody //The @ResponseBody annotation tells a controller that the object returned is automatically serialized into JSON and passed back to the HttpResponse object
@RestController
public class HelloWorldController {

    //HTTP GET Request
    //http://localhost:8080/hello-world
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World";
    }
}
