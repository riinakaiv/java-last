package ee.bcs.java.controller;

import ee.bcs.java.tasks.Lesson1;
import jdk.jfr.Registered;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    //http://localhost:8080/hello-world?name=Riina
    @GetMapping("hello-world")
    public String helloWorld(@RequestParam("name") String firstName) {
        return "Hello " + firstName;
    }
//http://localhost:8080/lesson1/min?a=236&b=890
    @GetMapping("lesson1/min")
    public int min(@RequestParam("a") int a, @RequestParam("b") int b) {
        return Lesson1.min(a, b);
    }
    //http://localhost:8080/lesson1/max?a=236&b=890
    @GetMapping("lesson1/max")
    public int max(@RequestParam("a") int a, @RequestParam("b") int b) {
        return Lesson1.max(a, b);
    }

    //http://localhost:8080/lesson1/abs?a=236
    @GetMapping("lesson1/abs")
    public int abs(@RequestParam("a") int a) {
        return Lesson1.abs(a);
    }


    //http://localhost:8080/lesson1/isevan?a=236
    @GetMapping("lesson1/isevan")
    public boolean isEvan(@RequestParam("a") int a) {
        return Lesson1.isEven(a);
    }

    //http://localhost:8080/lesson1/min3?a=236&b=890&c=100
    @GetMapping("lesson1/min3")
    public int min3(@RequestParam("a") int a, @RequestParam("b") int b, @RequestParam("c") int c) {
        return Lesson1.min3(a, b, c);
    }
    //http://localhost:8080/lesson1/max3?a=236&b=890&c=100

    @GetMapping("lesson1/max3")
    public int max3(@RequestParam("a") int a, @RequestParam("b") int b, @RequestParam("c") int c) {
        return Lesson1.max3(a, b, c);
    }

    //http://localhost:8080/lesson1/somestring
    @GetMapping("lesson1/somestring")
    public String someString() {
        return Lesson1.someString();
    }

    //http://localhost:8080/dtoMapping
    // http://localhost:8080/dtoMapping?name=Siim&address=USA&age=35
    @GetMapping("dtoMapping")
    public ClientDto [] dtoTest (@RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("age") Integer age) {
        ClientDto[] result = new ClientDto[2];
        List<ClientDto> result2 = new ArrayList<>();

        //result2.add(client); - lisab juurde ühe
        //result2.get(1); - array[1] kustutab ühe
        //result2.remove(1); - kustutab elemendi indeksil 1
        //result2.set(1, client); - kirjutab olemasoleva üle

        ClientDto client = new ClientDto();
        client.setName(name);
        client.setAddress(address);
        client.setId(age);
        result[0] = client;
        result2.add(client);

        ClientDto client2 = new ClientDto();
        client2.setName("John Smith");
        client2.setAddress("USA");
        client2.setId(18);
        result[1] = client2;

        return result;
    }


}
