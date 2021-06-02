package com.bistel.restfulwebservice.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    // GET
    //  /hello-world (endpoint)
    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path = "/hello-world-bean/path-variable/{name}")
//    public HelloWorldBean helloWorldBean(@PathVariable(value="name") String name) {
    public HelloWorldBean helloWorldBean(@PathVariable String name) {
//        return new HelloWorldBean("Hello World " + name);
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}
