package pl.edu.wszib.projectexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloController {

    @GetMapping("/hello")
    public String helloPage(){
        return  "Hello!!";
    }

    @GetMapping("/welcome")

    public String welcome(){
        return "Welcome in my application";
    }

}
