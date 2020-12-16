package ee.bcs.java.demo.tasks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonTestController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("json/test")
    public JsonMessage jsonTest(){
        JsonMessage jsonMessage = new JsonMessage();
        jsonMessage.name = "John";
        jsonMessage.address = "USA";
        return jsonMessage;
    }

    @PostMapping("register")
    public void register(@RequestBody LoginRequest request){
        System.out.println(request.username);
        System.out.println(request.password);
        String encodedPassword = passwordEncoder.encode(request.password);
        System.out.println(encodedPassword);
    }
}
