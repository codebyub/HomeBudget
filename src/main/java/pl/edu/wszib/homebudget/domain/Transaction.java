package pl.edu.wszib.homebudget.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue
    private long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private BigDecimal amount;
    private TransactionCategory category;
    private String description;

    public Transaction() {
    }

    public Transaction(LocalDate date, BigDecimal amount, TransactionCategory category, String description) {
        this.date = date;
        this.amount = amount;
        this.category = category;
        this.description = description;
    }

}
