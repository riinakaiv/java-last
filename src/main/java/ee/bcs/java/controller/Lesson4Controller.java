package ee.bcs.java.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.Map;
//@RestController

public class Lesson4Controller {
    Map<String, Integer> accounts = new HashMap<>();

    // http://localhost:8080/bank/createAccount?accountNumber=EE123
    @GetMapping("bank/createAccount")
    public String createAccount(@RequestParam("accountNumber") String accountNumber) {
        accounts.put(accountNumber, 0);
        return "Konto on loodud";
    }



    // http://localhost:8080/bank2/createAccount/EE123
    @GetMapping("bank2/createAccount/{accountNumber}")
    public String createAccount2(@PathVariable("accountNumber") String accountNumber) {
        accounts.put(accountNumber, 0);
        return "Konto on loodud";
    }




    // http://localhost:8080/bank/getBalance?accountNumber=EE123
    @GetMapping("bank/getBalance")
    public String getAccountBalance(@RequestParam("accountNumber") String accountNumber) {
        Integer balance = accounts.get(accountNumber);
        return "Kont jääk on:  " + balance;
    }


    // http://localhost:8080/bank2/getAccountBalance/EE123
    @GetMapping("bank2/getAccountBalance/{accountNumber}")
    public String getAccountBalance2(@PathVariable("accountNumber") String accountNumber) {
        Integer balance = accounts.get(accountNumber);
        return "Kont jääk on:  " + balance;
    }




    // http://localhost:8080/bank/depositMoney?accountNumber=EE123&amount=1600
    //ToDO oluline, amount > 0
    @GetMapping("bank/depositMoney")
    public String depositMoney(@RequestParam("accountNumber") String accountNumber,
                               @RequestParam("amount") Integer amount) {
        Integer balance = accounts.get(accountNumber);
        if (balance == null) {
            return "Sellist kontot pole olemas";

        } else if (amount < 0) {
            return "Summa peab olema suurem kui 0";
        } else {
            Integer newBalance = balance + amount;
            accounts.put(accountNumber, newBalance);
            return "Konto uus jääk on: " + newBalance;

        }
    }


    // http://localhost:8080/bank2/depositMoney/EE123/1600
    @GetMapping("bank2/depositMoney/{accountNumber}/{amount}")
    public String depositMoney2(@PathVariable("accountNumber") String accountNumber, @PathVariable("amount") Integer amount) {
        Integer balance = accounts.get(accountNumber);
        if (balance == null) {
            return "Sellist kontot pole olemas";

        } else if (amount < 0) {
            return "Summa peab olema suurem kui 0";
        } else {
            Integer newBalance = balance + amount;
            accounts.put(accountNumber, newBalance);
            return "Konto uus jääk on: " + newBalance;

        }
    }




    // http://localhost:8080/bank/withdrawMoney?accountNumber=EE123&amount=1500
    //ToDo amount>0
    //ToDO kontrolli et kontol on piisavalt raha
    @GetMapping("bank/withdrawMoney")
    public String withdrawMoney(@RequestParam("accountNumber") String accountNumber,
                                @RequestParam("amount") Integer amount) {
        Integer balance = accounts.get(accountNumber);
        if (amount < 0) {
            return "Summa peab olema suurem kui 0";
        } else if (amount > balance) {
            return "Kontol pole piisavalt raha";
        } else {
            Integer newBalance = balance - amount;
            accounts.put(accountNumber, newBalance);
            return "Konto uus jääk on: " + newBalance;
        }
    }
    // http://localhost:8080/bank2/withdrawMoney/EE123/1500
    @GetMapping("bank2/withdrawMoney/{accountNumber}/{amount}")
    public String withdrawMoney2(@PathVariable("accountNumber") String accountNumber,
                                 @PathVariable("amount") Integer amount) {
        Integer balance = accounts.get(accountNumber);
        if (amount < 0) {
            return "Summa peab olema suurem kui 0";
        } else if (amount > balance) {
            return "Kontol pole piisavalt raha";
        } else {
            Integer newBalance = balance - amount;
            accounts.put(accountNumber, newBalance);
            return "Konto uus jääk on: " + newBalance;
        }
    }



    //http://localhost:8080/bank/transferMoney?fromAccountNumber=EE123&toAccountNumber=EE124&amount=1500
    //ToDo amount>0
    // TODO fromAccount balance >= amount

    @GetMapping("bank/transferMoney")
    public String transferMoney(@RequestParam("fromAccountNumber") String fromAccountNumber,
                                @RequestParam("toAccountNumber") String toAccountNumber,
                                @RequestParam("amount") Integer amount) {
        Integer fromBalance = accounts.get(fromAccountNumber);
        if (amount < 0) {
            return "Summa peab olema suurem kui 0";
        } else if (fromBalance < amount) {
            return "Kontol pole piisavalt raha";
        } else {
            Integer toBalance = accounts.get(toAccountNumber);
            Integer newFromBalance = fromBalance -amount;
            Integer newToBalance = toBalance + amount;
            accounts.put(fromAccountNumber, newFromBalance);
            accounts.put(toAccountNumber, newToBalance);
            return "Ülekanne kontolt tehtud";
        }

    }
    //http://localhost:8080/bank2/transferMoney/EE123/EE124/1500

    @GetMapping("bank2/transferMoney/{fromAccountNumber}/{toAccountNumber}/{amount}")
    public String transferMoney2(@PathVariable("fromAccountNumber") String fromAccountNumber,
                                 @PathVariable("toAccountNumber") String toAccountNumber,
                                 @PathVariable("amount") Integer amount) {
        Integer fromBalance = accounts.get(fromAccountNumber);
        if (amount < 0) {
            return "Summa peab olema suurem kui 0";
        } else if (fromBalance < amount) {
            return "Kontol pole piisavalt raha";
        } else {
            Integer toBalance = accounts.get(toAccountNumber);
            Integer newFromBalance = fromBalance -amount;
            Integer newToBalance = toBalance + amount;
            accounts.put(fromAccountNumber, newFromBalance);
            accounts.put(toAccountNumber, newToBalance);
            return "Ülekanne kontolt tehtud";
        }

    }

}

