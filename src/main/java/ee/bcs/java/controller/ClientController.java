package ee.bcs.java.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//result2.add(client); - lisab juurde ühe
//result2.get(1); - array[1] kustutab ühe
//result2.remove(1); - kustutab elemendi indeksil 1
//result2.set(1, client); - kirjutab olemasoleva üle


//@RestController
public class ClientController {
    private List<ClientDto> clients = new ArrayList<>();


    //http://localhost:8080/client/createClient?name=John&address=USA&age=33
    @GetMapping("client/createClient")
    public String createClient(@RequestParam("name") String name,
                               @RequestParam("address") String address,
                               @RequestParam("age") Integer age) {

        ClientDto client = new ClientDto();
        client.setName(name);
        client.setAddress(address);
        client.setId(age);
        clients.add(client);
        return "Klient on loodud";
    }



    //http:/localhost:8080/client (GET)
    //http://localhost:8080/client/getAllClients
    @GetMapping("client/getAllClients")
    public List<ClientDto> getAllClient() {
        return clients;
    }


    //http://localhost:8080/client/1 (GET)
    //http://localhost:8080/client/getClient/1
    @GetMapping("client/getClient/{i}")
    public ClientDto getClient (@PathVariable("i") Integer index) {

        return clients.get(index);
        //tagastada 1 klient
    }


    //http://localhost:8080/client/1 DELETE
    //http://localhost:8080/client/deleteClient/1
    @GetMapping("client/deleteClient/{i}")
    public String deleteClient  (@PathVariable("i") Integer i) {
        clients.remove(i);
        return "Kustutatud";

        //eemalda clients listist indeksiga i klient
        //result2.remove(1); - kustutab elemendi indeksil 1
    }


    //http:/localhost:8080/client?name=John&address=USA&age=33 PUT
    //http://localhost:8080/client/updateClient/1?name=John&address=USA&age=33

    @GetMapping("client/updateClient/{i}")
    public void updateClient(@PathVariable("i") Integer i,
                             @RequestParam("name") String name,
                             @RequestParam("address") String address,
                             @RequestParam("age") Integer age) {



        ClientDto newClient = new ClientDto();
        newClient.setName(name);
        newClient.setAddress(address);
        newClient.setId(age);

        clients.set(i, newClient);

        //kirjuta indeksiga i klient üle uute andmetega
    }


}
