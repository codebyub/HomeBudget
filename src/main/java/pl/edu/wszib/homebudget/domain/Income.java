package pl.edu.wszib.homebudget.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Income {

    private long id;
    private Date date;
    private BigDecimal amount;
    private final String INCOME_CATEGORY = "Przychody";
    private String description;

}
