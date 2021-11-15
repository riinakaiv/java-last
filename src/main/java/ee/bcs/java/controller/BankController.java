package ee.bcs.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BankController {



    @Autowired
    private BankService bankService;

    //http://localhost:8080/bank/createAccount?name=Mari&accountNr=EE123&amount=0
    @GetMapping("bank/createAccount")
    public String createAccount(@RequestParam("name") String name,
                                @RequestParam("accountNr") String accountNr,
                                @RequestParam("amount") Integer amount) {

        return bankService.createAccount(name, accountNr, amount);
    }


    //http://localhost:8080/bank/getBalance?accountNr=127
    @GetMapping("bank/getBalance")
    public Integer getBalance(@RequestParam("accountNr") String accountNr) {
        return bankService.getBalance(accountNr);
    }


    //http://localhost:8080/bank/depositMoney?accountNr=EE130&amount=500
    @GetMapping("bank/depositMoney")
    public String depositMoney(@RequestParam("accountNr") String accountNr,
                               @RequestParam("amount") Integer amount) {

        return bankService.depositMoney(accountNr, amount);

    }

    //http://localhost:8080/bank/withdrawMoney?accountNr=EE130&amount=400
    @GetMapping("bank/withdrawMoney")
    public String withdrawMoney(@RequestParam("accountNr") String accountNr,
                                @RequestParam("amount") Integer amount) {

        return bankService.withdrawMoney(accountNr, amount);

    }

    //http://localhost:8080/bank/transferMoney?fromAccount=EE123&toAccount=EE130&amount=700
    @GetMapping("bank/transferMoney")
    public String transferMoney(@RequestParam("fromAccount") String fromAccount,
                                @RequestParam("toAccount") String toAccount,
                                @RequestParam("amount") Integer amount) {

        return bankService.transferMoney(fromAccount, toAccount, amount);
    }



    //http://localhost:8080/bank/transactionHistory?accountNr=EE123&from=2021-11-01&to=2021-11-03
    @GetMapping("bank/transactionHistory")
    public List<TransactionDto> getTransactionHistory(
            @RequestParam("accountNr") String accountNr,
            @RequestParam(value = "from", required = false) String from,
            @RequestParam(value = "to", required = false) String to
    ) {

        return bankService.getTransactionHistory(accountNr, from, to);
    }

}
