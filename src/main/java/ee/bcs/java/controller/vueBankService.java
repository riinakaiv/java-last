package ee.bcs.java.controller;

import ee.bcs.java.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service


public class vueBankService {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    private vueBankRepository vuebankRepository;

    public List<TransactionDto> getTransactionHistory(String accountNr, String from, String to) {
        String sql = "SELECT * FROM transaction WHERE (fromaccount = :account_nr OR toaccount = :account_nr) ";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nr", accountNr);

        if (from != null) {
            sql = sql + " AND created >= :from";
            LocalDate fromDate = LocalDate.parse(from);
            paramMap.put("from", fromDate);
        }
        if (to != null) {
            sql = sql + "  AND created < :to";
            LocalDate toDate = LocalDate.parse(to);
            paramMap.put("to", toDate.plusDays(1));
        }
        return jdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<>(TransactionDto.class));
    }

    public String createAccount(String name, String accountNr, Integer amount) {
        vuebankRepository.createAccount(name, accountNr, amount);
        return "Klient on loodud";
    }

    public Integer getBalance(String accountNr) {
        return vuebankRepository.getBalance(accountNr);
    }

    public String depositMoney(String accountNr, Integer amount) {
        if (amount < 0) {
            throw new MyException("Summa peab olema positiivne");
        }
        Integer currentBalance = vuebankRepository.getBalance(accountNr);
        Integer newBalance = currentBalance + amount;
        vuebankRepository.updateNewBalance(accountNr, newBalance);
        vuebankRepository.insertTransaction(accountNr, amount);

        return "Konto uus jääk on:" + newBalance;
    }

    public String withdrawMoney(String accountNr, Integer amount) {
        if (amount < 0) {
            throw new MyException("Summa peab olema positiivne");
        }
        Integer currentBalance = vuebankRepository.getBalance(accountNr);
        Integer newBalance = currentBalance - amount;

        if (amount > currentBalance) {
            throw new MyException("Summa peab olema suurem kui konto jääk");
        }


        vuebankRepository.updateWithNewBalance(accountNr, newBalance);
        vuebankRepository.insertToTransaction(accountNr, amount);

        return "Konto uus jääk on:" + newBalance;

    }

    public String transferMoney(String fromAccount, String toAccount, Integer amount) {
        if (amount < 0) {
            throw new MyException("Summa peab olema positiivne") ;
        }

        Integer tocurrentBalance = vuebankRepository.getBalance(toAccount);
        Integer fromCurrentBalance = vuebankRepository.getBalance(fromAccount);

        if (amount > fromCurrentBalance) {
            throw new MyException("Summa peab olema suurem kui konto jääk") ;
        }

        Integer newbalancetoAccount = tocurrentBalance + amount;
        Integer newBalancefromAccount = fromCurrentBalance - amount;

        vuebankRepository.updateNewBalance(fromAccount, newBalancefromAccount);
        vuebankRepository.updateNewBalance(toAccount, newbalancetoAccount);
        vuebankRepository.insertToandFromTransaction(fromAccount, amount, toAccount);


        return "Ülekanne tehtud";
    }



}








