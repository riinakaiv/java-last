package ee.bcs.java.controller;

public class BankDto {
    private Integer id;
    private String name;
    private Integer accountNr;
    private Integer amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAccountNr() {
        return accountNr;
    }

    public void setAccountNr(Integer accountNr) {
        this.accountNr = accountNr;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }


}
