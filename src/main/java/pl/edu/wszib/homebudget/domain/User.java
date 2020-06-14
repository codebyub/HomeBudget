package pl.edu.wszib.homebudget.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import java.util.Collection;


@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private long userId;
    @NotNull
    @Size(
            min = 2,
            message = "{user.name.notNull}"
    )
    private String name;
    @NotNull (message = "{user.balance.notNull}")
    private BigDecimal compensateBalance;
    @CreationTimestamp
    private LocalDateTime ctime;
    @UpdateTimestamp
    private LocalDateTime utime;

    public User() {
    }

    public User(String name, BigDecimal compensateBalance, LocalDateTime ctime, LocalDateTime utime) {
        this.name = name;
        this.compensateBalance = compensateBalance;
        this.ctime = ctime;
        this.utime = utime;
    }

}
