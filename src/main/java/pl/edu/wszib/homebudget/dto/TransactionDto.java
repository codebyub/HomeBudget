package pl.edu.wszib.homebudget.dto;

import lombok.Data;
import pl.edu.wszib.homebudget.domain.TransactionCategory;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class TransactionDto {

    private long id;
    @NotNull(message = "{transaction.date.notNull}")
    @PastOrPresent(message = "{transaction.date.notFuture}")
    private LocalDate date;
    @NotNull(message = "{transaction.amount.notNull}")
    private BigDecimal amount;
    private TransactionCategory category;
    private String description;
    private LocalDateTime updateDate;
    private boolean deleted;

}
