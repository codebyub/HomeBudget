package pl.edu.wszib.homebudget.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Expense {

    private long id;
    private Date date;
    private BigDecimal amount;
    private ExpenseCategory category;
    private String description;

}
