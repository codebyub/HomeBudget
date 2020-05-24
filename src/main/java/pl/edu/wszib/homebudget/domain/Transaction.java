package pl.edu.wszib.homebudget.domain;

import lombok.Data;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue
    private long id;
    @PastOrPresent(message = "!!!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    /*    @Formula("balance-amount")*/
    private BigDecimal balance;
    private BigDecimal amount;
    private TransactionCategory category;
    private String description;
    @UpdateTimestamp
    private LocalDateTime updateDate;

    public Transaction() {
    }

    public Transaction(LocalDate date, BigDecimal balance, BigDecimal amount, TransactionCategory category, String description, LocalDateTime updateDate) {
        this.date = date;
        this.balance = balance;
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.updateDate = updateDate;
    }

}
