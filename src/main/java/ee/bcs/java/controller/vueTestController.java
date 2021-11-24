package ee.bcs.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class vueTestController {
    @Autowired
    private vueBankService vuebankService;

    @PostMapping("vue-test/register")
    public String register(@RequestBody RegisterRequest request) {
        return vuebankService.createAccount(request.getName(), request.getAccount(), request.getAmount());
    }

    //http://localhost:8080/vue-/getBalance?accountNr=127
    @GetMapping("vue-test/getBalance")
    public Integer getBalance(@RequestParam("accountNr") String accountNr) {
        return vuebankService.getBalance(accountNr);
    }


    //http://localhost:8080/vue-test/depositMoney?accountNr=EE130&amount=500
    @GetMapping("vue-test/depositMoney")
    public String depositMoney(@RequestParam("accountNr") String accountNr,
                               @RequestParam("amount") Integer amount) {

        return vuebankService.depositMoney(accountNr, amount);
    }

    //http://localhost:8080/vue-test/withdrawMoney?accountNr=EE130&amount=400
    @GetMapping("vue-test/withdrawMoney")
    public String withdrawMoney(@RequestParam("accountNr") String accountNr,
                                @RequestParam("amount") Integer amount) {

        return vuebankService.withdrawMoney(accountNr, amount);

    }

    //http://localhost:8080/vue-test/transferMoney?fromAccount=EE123&toAccount=EE130&amount=700
    @GetMapping("vue-test/transferMoney")
    public String transferMoney(@RequestParam("fromAccount") String fromAccount,
                                @RequestParam("toAccount") String toAccount,
                                @RequestParam("amount") Integer amount) {

        return vuebankService.transferMoney(fromAccount, toAccount, amount);
    }

    //http://localhost:8080/vue-test/transactionHistory?accountNr=EE123&from=2021-11-01&to=2021-11-03
    @GetMapping("vue-test/transactionHistory")
    public List<TransactionDto> getTransactionHistory(
            @RequestParam("accountNr") String accountNr,
            @RequestParam(value = "from", required = false) String from,
            @RequestParam(value = "to", required = false) String to
    ) {

        return vuebankService.getTransactionHistory(accountNr, from, to);
    }


    @GetMapping("vue-test/data")
    public RegisterRequest getData() {
        RegisterRequest data = new RegisterRequest();
        data.setAccount("Tallinn");
        data.setName("Mari");
        data.setAmount(500);
        return data;
    }

}
