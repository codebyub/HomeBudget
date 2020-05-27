package pl.edu.wszib.homebudget.domain;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    @PastOrPresent(message = "!!!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @NotNull(message = "Wydatek/Wpływ nie może być 0!")
    private BigDecimal amount;
    private TransactionCategory category;
    private String description;
    @UpdateTimestamp
    @ColumnDefault(value = "current_timestamp")
    private LocalDateTime updateDate;

    public Transaction() {
    }

    public Transaction(LocalDate date, BigDecimal amount, TransactionCategory category, String description, LocalDateTime updateDate) {
        this.date = date;
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.updateDate = updateDate;
    }

}
