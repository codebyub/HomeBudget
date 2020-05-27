package pl.edu.wszib.homebudget.domain;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private long userId;
    private String name;
    /*    @OneToMany(targetEntity = UserFinance.class, mappedBy = "user")
        Set<UserFinance> userFinanceSet;*/
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
