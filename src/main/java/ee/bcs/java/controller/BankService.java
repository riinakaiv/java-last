package ee.bcs.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {


    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    private BankRepository bankRepository;

    public String createAccount(String name, String accountNr, Integer amount) {
        bankRepository.createAccount(name, accountNr, amount);
        return "Klient on loodud";
    }


    public Integer getBalance(String accountNr) {
        return bankRepository.getBalance(accountNr);
    }


    public String depositMoney(String accountNr, Integer amount) {
        if (amount < 0) {
            return "Amount peab olema positiivne";
        }
        Integer currentBalance = bankRepository.getBalance(accountNr);
        Integer newBalance = currentBalance + amount;
        bankRepository.updateNewBalance(accountNr, newBalance);
        bankRepository.insertTransaction(accountNr, amount);

        return "Konto uus jääk on:" + newBalance;
    }


    public String withdrawMoney(String accountNr, Integer amount) {
        if (amount < 0) {
            return "Amount peab olema positiivne";
        }
        Integer currentBalance = bankRepository.getBalance(accountNr);
        Integer newBalance = currentBalance - amount;

        if (amount > currentBalance) {
            return "Summa peab olema suurem kui konto jääk";
        }

        bankRepository.updateWithNewBalance(accountNr, newBalance);
        bankRepository.insertToTransaction(accountNr, amount);

        return "Konto uus jääk on:" + newBalance;

    }

    public String transferMoney(String fromAccount, String toAccount, Integer amount) {
        if (amount < 0) {
            return "Amount peab olema positiivne";
        }

        Integer tocurrentBalance = bankRepository.getBalance(toAccount);
        Integer fromCurrentBalance = bankRepository.getBalance(fromAccount);

        if (amount > fromCurrentBalance) {
            return "Summa peab olema suurem kui konto jääk";
        }

        Integer NewbalancetoAccount = tocurrentBalance + amount;
        Integer newBalancefromAccount = fromCurrentBalance - amount;

        bankRepository.updateNewBalance(fromAccount, amount);
        bankRepository.updateNewBalance(toAccount, amount);
        bankRepository.insertToandFromTransaction(fromAccount, amount, toAccount);


        return "Ülekanne tehtud";
    }


    public List<TransactionDto> getTransactionHistory(String accountNr, String from, String to) {

        return bankRepository.getTransactionHistory(accountNr, from, to);

    }

}
