package ee.bcs.java.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//result2.add(client); - lisab juurde ühe
//result2.get(1); - array[1] kustutab ühe
//result2.remove(1); - kustutab elemendi indeksil 1
//result2.set(1, client); - kirjutab olemasoleva üle


//@RestController
public class Client2Controller {
    private List<ClientDto> clients = new ArrayList<>();


    //http://localhost:8080/client?name=John&address=USA&age=33 (POST - lisada)
    @PostMapping("client")
    public String createClient (@RequestBody ClientDto client) {
        clients.add(client);

    //(@RequestParam("name") String name,
                              // @RequestParam("address") String address,
                               //@RequestParam("age") Integer age) {

       // ClientDto client = new ClientDto();
        //client.setName(name);
    //client.setAddress(address);
    //client.setAge(age);
    // clients.add(client);
        return "Klient on loodud";
    }


    //http://localhost:8080/client (GET)
    @GetMapping("client")
    public List<ClientDto> getAllClient() {
        return clients;
    }


    //http://localhost:8080/client/1 (GET)
    @GetMapping("client/{id}")
    public ClientDto getClient (@PathVariable("id") int id) {

        return clients.get(id);
        //tagastada 1 klient
    }


    //http://localhost:8080/client/1 DELETE
    @DeleteMapping("client/{id}")
    public String deleteClient  (@PathVariable("id") int id) {
        clients.remove(id);
        return "Kustutatud";

        //eemalda clients listist indeksiga i klient
        //result2.remove(1); - kustutab elemendi indeksil 1
    }


    //http://localhost:8080/client/1
    // ?name=John&address=USA&age=33 PUT
    @PutMapping("client/{id}")
    public void updateClient(@PathVariable("id") int id,
                             @RequestBody ClientDto newClient) {

    // ,
    //@RequestParam("name") String name,
    //@RequestParam("address") String address,
    //@RequestParam("age") Integer age) {

    //ClientDto newClient = new ClientDto();
    //newClient.setName(name);
    //newClient.setAddress(address);
    //newClient.setAge(age);

        clients.set(id, newClient);

        //kirjuta indeksiga i klient üle uute andmetega
    }


}
