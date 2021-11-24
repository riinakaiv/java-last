package ee.bcs.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class vueBankRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public String createAccount(String name, String accountNr, Integer amount) {
        String sql = "INSERT INTO bank_table (name, account_nr, amount) VALUES (:sqlname, :sqlaccountNr, :sqlamount)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("sqlname", name);
        paramMap.put("sqlaccountNr", accountNr);
        paramMap.put("sqlamount", amount);
        jdbcTemplate.update(sql, paramMap);
        return "Klient on loodud";
    }

    public Integer getBalance(String accountNr) {
        String sql = "SELECT amount FROM bank_table WHERE account_nr = :account_nr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nr", accountNr);
        return jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }


    public void updateNewBalance(String accountNr, Integer newBalance) {
        String sql2 = "UPDATE bank_table SET amount = :newBalance WHERE account_nr = :account_nr";
        Map<String, Object> paramMap2 = new HashMap<>();
        paramMap2.put("account_nr", accountNr);
        paramMap2.put("newBalance", newBalance);
        jdbcTemplate.update(sql2, paramMap2);
    }

    public void insertTransaction(String accountNr, Integer amount) {
        String sql3 = "INSERT INTO transaction (toaccount, type, amount) VALUES (:sqltoaccount, :sqltype, :sqlamount)";
        Map<String, Object> paramMap3 = new HashMap<>();
        paramMap3.put("sqltoaccount", accountNr);
        paramMap3.put("sqltype", "deposit");
        paramMap3.put("sqlamount", amount);
        jdbcTemplate.update(sql3, paramMap3);

    }

    public void updateWithNewBalance(String accountNr, Integer newBalance) {
        String sql2 = "UPDATE bank_table SET amount = :newBalance WHERE account_nr = :account_nr";
        Map<String, Object> paramMap2 = new HashMap<>();
        paramMap2.put("account_nr", accountNr);
        paramMap2.put("newBalance", newBalance);
        jdbcTemplate.update(sql2, paramMap2);

    }

    public void insertToTransaction(String accountNr, Integer amount) {
        String sql3 = "INSERT INTO transaction (toaccount, type, amount) VALUES (:sqltoaccount, :sqltype, :sqlamount)";
        Map<String, Object> paramMap3 = new HashMap<>();
        paramMap3.put("sqltoaccount", accountNr);
        paramMap3.put("sqltype", "withdraw");
        paramMap3.put("sqlamount", amount);
        jdbcTemplate.update(sql3, paramMap3);

    }

    public void insertToandFromTransaction(String fromAccount, Integer amount, String toAccount) {
        String sql5 = "INSERT INTO transaction (fromaccount, type, amount, toaccount) VALUES (:fromaccount, :type, :amount, :toaccount)";
        Map<String, Object> paramMap5 = new HashMap<>();
        paramMap5.put("fromaccount", fromAccount);
        paramMap5.put("type", "transfer");
        paramMap5.put("amount", amount);
        paramMap5.put("toaccount", toAccount);
        jdbcTemplate.update(sql5, paramMap5);
    }

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


}
