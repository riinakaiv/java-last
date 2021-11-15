package ee.bcs.java.controller;

import ee.bcs.java.tasks.Lesson3Hard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class RandomGameController {

    Random random = new Random();
    int i = random.nextInt(100);
    int count = 0;


    //http://localhost:8080/game/?nr=50
    @GetMapping("game")
    public String guess(@RequestParam("nr") int nr) {
        count++;
        if (nr > i) {
            return "Väiksem";
        } else if (nr < i) {
            return "Suurem";
        } else {
            int tempi = i;
            i = random.nextInt(100);
            int tempcount = count;
            count = 0;
            return tempcount + " korda kulus arvamiseks. Tubli! Õige vastus on " + tempi;
        }
    }

}

