package pl.edu.wszib.homebudget.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import pl.edu.wszib.homebudget.domain.Transaction;
import pl.edu.wszib.homebudget.domain.TransactionCategory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransactionDaoTest {

    /*Data for tests*/
    public static final LocalDate DATE1 = LocalDate.of(2020, Month.MAY, 10);
    public static final LocalDate DATE2 = LocalDate.of(2020, Month.APRIL, 10);
    public static final LocalDate DATE3 = LocalDate.of(2020, Month.FEBRUARY, 15);
    public static final LocalDate DATE4 = LocalDate.of(2019, Month.OCTOBER, 29);
    public static final BigDecimal AMOUNT1 = BigDecimal.valueOf(4765.24);
    public static final BigDecimal AMOUNT2 = BigDecimal.valueOf(5265.55);
    public static final BigDecimal AMOUNT3 = BigDecimal.valueOf(367.99);
    public static final BigDecimal AMOUNT4 = BigDecimal.valueOf(78923.00);
    public static final TransactionCategory CAT1 = TransactionCategory.INCOME;
    public static final TransactionCategory CAT2 = TransactionCategory.INCOME;
    public static final TransactionCategory CAT3 = TransactionCategory.BILL;
    public static final TransactionCategory CAT4 = TransactionCategory.CAR;
    public static final String DESC1 = "wynagrodzenie";
    public static final String DESC2 = "Wynagrodzenie";
    public static final String DECS3 = "Energia elektryczna";
    public static final String DESC4 = "Zakup samochodu osobwego z salonu";
    public static final LocalDateTime RIGHT_NOW = LocalDateTime.from(LocalDateTime.now());
    public static final int TOTAL_COUNTER = 4;
    public static final int ALL_EXPENSES_COUNTER = 2;
    public static final int INCOMES_IN_CURRENT_MONTH = 1;
    public static final int ALL_IN_CURRENT_MONTH = 1;
    public static final int ALL_IN_CURRENT_YEAR = 3;


    @Autowired
    TransactionDao transactionDao;

    @BeforeEach
    void setUp() {
        Transaction transaction1 = new Transaction(DATE1, AMOUNT1, CAT1, DESC1, RIGHT_NOW);
        Transaction transaction2 = new Transaction(DATE2, AMOUNT2, CAT2, DESC2, RIGHT_NOW);
        Transaction transaction3 = new Transaction(DATE3, AMOUNT3, CAT3, DECS3, RIGHT_NOW);
        Transaction transaction4 = new Transaction(DATE4, AMOUNT4, CAT4, DESC4, RIGHT_NOW);

        transactionDao.save(transaction1);
        transactionDao.save(transaction2);
        transactionDao.save(transaction3);
        transactionDao.save(transaction4);

        assertNotNull(transaction1.getId());
        assertNotNull(transaction2.getId());
        assertNotNull(transaction3.getId());
        assertNotNull(transaction4.getId());
    }

    @AfterEach
    void tearDown() {
        transactionDao.deleteAll();
    }

    @Test
    void testFetchAllData() {
        Collection transactions = (Collection) transactionDao.findAll();
        assertEquals(TOTAL_COUNTER, transactions.size());
    }

    @Test
    void testFetchAllExpensesData() {
        Collection transactions = (Collection) transactionDao.findAllExpenses();
        assertEquals(ALL_EXPENSES_COUNTER, transactions.size());
    }

    @Test
    void testFetchMonthyIncomesData() {
        Collection transactions = (Collection) transactionDao.findIncomesInCurrentMonth();
        assertEquals(INCOMES_IN_CURRENT_MONTH, transactions.size());
    }

    @Test
    void testFetchAllInCurrentMonthData() {
        Collection transactions = (Collection) transactionDao.findAllInCurrentMonth();
        assertEquals(ALL_IN_CURRENT_MONTH, transactions.size());
    }

    @Test
    void testFetchAllInCurrentYearData() {
        Collection transactions = (Collection) transactionDao.findAllInCurrentYear();
        assertEquals(ALL_IN_CURRENT_YEAR, transactions.size());
    }

}