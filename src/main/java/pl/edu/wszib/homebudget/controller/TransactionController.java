package pl.edu.wszib.homebudget.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.wszib.homebudget.dao.TransactionDao;
import pl.edu.wszib.homebudget.domain.Transaction;

@Controller
public class TransactionController {

    @Autowired
    private TransactionDao transactionDao;

    @GetMapping
    public String welcome() {
        return "entry";
    }

    @GetMapping("expenses")
    public String expenses(Model model) {
        model.addAttribute("expenses", transactionDao.findAll());
        return "expenses";
    }

    @GetMapping("expenses/new")
    public String newExpense(Model model) {
        model.addAttribute("expense", new Transaction());
        return "expense";
    }

    @PostMapping("expenses/save")
    public String saveExpense(Transaction transaction) {
        transactionDao.save(transaction);
        return "redirect:/expenses";
    }

    @GetMapping("expenses/edit/{id}")
    public String editExpenseForm(@PathVariable long id, Model model) {
        model.addAttribute("expense", transactionDao.findById(id));
        return "expense";
    }

    @GetMapping("expenses/delete/{id}")
    public String deleteExpense(@PathVariable long id) {
        transactionDao.deleteById(id);
        return "redirect:/expenses";
    }

    @GetMapping("incomes")
    public String incomes(Model model) {
        model.addAttribute("incomes", transactionDao.findIncomesInCurrentMonth());
        return "incomes";
    }

    @GetMapping("incomes/new")
    public String newIncome(Model model) {
        model.addAttribute("income", new Transaction());
        return "income";
    }

    @PostMapping("incomes/save")
    public String saveIncome(Transaction transaction) {
        transactionDao.save(transaction);
        return "redirect:/incomes";
    }

    @GetMapping("incomes/edit/{id}")
    public String editIncomeForm(@PathVariable long id, Model model) {
        model.addAttribute("income", transactionDao.findById(id));
        return "income";
    }

    @GetMapping("incomes/delete/{id}")
    public String deleteIncome(@PathVariable long id) {
        transactionDao.deleteById(id);
        return "redirect:/incomes";
    }

    @GetMapping("this-month")
    public String thisMonth(Model model) {
        model.addAttribute("transactions", transactionDao.findAllInCurrentMonth());
        return "monthly-balance";
    }

    @GetMapping("this-year")
    public String thisYear(Model model) {
        model.addAttribute("transactions", transactionDao.findAllInCurrentYear());
        return "annual-balance";
    }
}