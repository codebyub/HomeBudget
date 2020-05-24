package pl.edu.wszib.homebudget.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import pl.edu.wszib.homebudget.domain.Transaction;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;


@Repository
public interface TransactionDao extends CrudRepository<Transaction, Long> {

    List<Transaction> findAll();

    @Query(value = "SELECT t FROM Transaction t WHERE t.category <> 12 ORDER BY t.date DESC ")
    Collection<Transaction> findAllExpenses();

    @Query(value = "SELECT t FROM Transaction t WHERE t.category = 12 AND month(t.date) = month(CURRENT_DATE) AND year(t.date) = year(CURRENT_DATE) ORDER BY t.date DESC")
    Collection<Transaction> findIncomesInCurrentMonth();

    @Query(value = "SELECT t FROM Transaction t WHERE month(t.date) = month(CURRENT_DATE) AND year(t.date) = year(CURRENT_DATE) ORDER BY t.date DESC")
    Collection<Transaction> findAllInCurrentMonth();

    @Query(value = "SELECT t FROM Transaction t WHERE year(t.date) = year(CURRENT_DATE) ORDER BY t.date DESC")
    Collection<Transaction> findAllInCurrentYear();

    @Query(value = "SELECT sum(amount) FROM Transaction")
    BigDecimal total();

}
