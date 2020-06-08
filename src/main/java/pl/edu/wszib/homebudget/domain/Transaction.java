package pl.edu.wszib.homebudget.domain;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "transactions")
@SQLDelete(sql = "UPDATE transactions SET deleted=true WHERE id=?")
@Where(clause = "deleted = false")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull(message = "{transaction.date.notNull}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "{transaction.date.notFuture}")
    private LocalDate date;
    @NotNull(message = "{transaction.amount.notNull}")
    private BigDecimal amount;
    private TransactionCategory category;
    private String description;
    @UpdateTimestamp
    @ColumnDefault(value = "current_timestamp")
    private LocalDateTime updateDate;
    private boolean deleted;

    public Transaction() {
    }

    public Transaction(LocalDate date, BigDecimal amount, TransactionCategory category, String description, LocalDateTime updateDate, boolean deleted) {
        this.date = date;
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.updateDate = updateDate;
        this.deleted = deleted;
    }

}
