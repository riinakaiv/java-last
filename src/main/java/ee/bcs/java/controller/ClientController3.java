package ee.bcs.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ClientController3 {


    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    private List<ClientDto> clients = new ArrayList<>();

    //http://localhost:8080/client2/createClient?name=John&address=USA&age=33
    @GetMapping("client2/createClient")
    public String createClient(@RequestParam("name") String name,
                               @RequestParam("address") String address,
                               @RequestParam("age") Integer age) {

        String sql = "INSERT INTO client (name, address) VALUES (:sqlName, :sqlAddress)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("sqlName", name);
        paramMap.put("sqlAddress", address);
        jdbcTemplate.update(sql, paramMap);
        return "Klient on loodud";

    }


    //http://localhost:8080/client/1
    @DeleteMapping("client2/{id}")
    public String deleteClient(@PathVariable("id") int id) {
        String sql = "DELETE FROM client WHERE id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        jdbcTemplate.update(sql, paramMap);
        return "Kustutatud";

    }

    //http://localhost:8080/client2/getName/1
    @GetMapping("client2/getName/{id}") //bilanssi küsiminie
    public String getName(@PathVariable("id") Integer id) {
        String sql = "SELECT name FROM client WHERE id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        String name = jdbcTemplate.queryForObject(sql, paramMap, String.class); //tagastab ühe objekti
        return name;

    }



    //http://localhost:8080/client2/getAllClients (GET)
    @GetMapping("client2/getAllClients")
    public List<ClientDto> getAllClients() {
        String sql = "SELECT * FROM client";
        Map<String, Object> paramMap = new HashMap<>();
        List<ClientDto> result = jdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<>(ClientDto.class)); //tagastab terve andmebaasi

        return result;
    }






    //http://localhost:8080/client2/1 (GET)
    @GetMapping("client2/{id}")
    public ClientDto getClient(@PathVariable("id") int id) {
        String sql = "SELECT * FROM client WHERE id = :id ";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);

        return jdbcTemplate.queryForObject(sql, paramMap, new BeanPropertyRowMapper<>(ClientDto.class));
    }


    //http://localhost:8080/client2/3
    // //?name=John&address=USA&age=33 PUT
    @PutMapping("client2/{id}")
    public void updateClient(@PathVariable("id") int id,
                             @RequestBody ClientDto newClient) {
        String sql = "UPDATE client SET name = :name WHERE id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        paramMap.put("name", newClient.getName());


        jdbcTemplate.update(sql, paramMap);

    }
}
