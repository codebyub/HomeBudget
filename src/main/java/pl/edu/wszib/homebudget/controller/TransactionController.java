package pl.edu.wszib.homebudget.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.wszib.homebudget.dao.TransactionDao;
import pl.edu.wszib.homebudget.dao.UserDao;
import pl.edu.wszib.homebudget.domain.Transaction;
import pl.edu.wszib.homebudget.dto.TransactionDto;
import pl.edu.wszib.homebudget.service.TransactionService;

import javax.validation.Valid;

@Controller
public class TransactionController {

    TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @Autowired
    private TransactionDao transactionDao;

    @Autowired
    private UserDao userDao;

    @GetMapping
    public String welcome() {
        return "entry";
    }

    @GetMapping("expenses")
    public String expenses(Model model) {
        model.addAttribute("expenses", service.list());
        return "expenses";
    }

    @GetMapping("expenses/new")
    public String newExpense(Model model) {
        model.addAttribute("expense", new Transaction());
        return "expense";
    }

    @PostMapping("expenses/save")
    public String saveExpense(@Valid @ModelAttribute("expense") TransactionDto transactionDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("expense", transactionDto);
            return "expense";
        }
        /*transaction.setAmount(transaction.getAmount().negate());*/
        service.create(transactionDto);
        return "redirect:/expenses";
    }

    @GetMapping("expenses/edit/{id}")
    public String editExpenseForm(@PathVariable Integer id, Model model) {
        model.addAttribute("expense", service.get(id));
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
    public String saveIncome(@Valid @ModelAttribute("income") Transaction transaction, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("income", transaction);
            return "income";
        }
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

    @GetMapping("statistics")
    public String stats(Model model) {
        model.addAttribute("transactions", transactionDao.findAllInCurrentYear());
        /*model.addAttribute("salaries", transactionDao.findSalariesInCurrentYear());*/
        model.addAttribute("users", userDao.findAll());
        return "stats";
    }

}