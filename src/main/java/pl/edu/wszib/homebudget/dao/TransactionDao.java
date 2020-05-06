package pl.edu.wszib.homebudget.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.homebudget.domain.Transaction;


@Repository
public interface TransactionDao extends CrudRepository <Transaction, Long> {

    Iterable<Transaction> findAll();

}
