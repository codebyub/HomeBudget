package pl.edu.wszib.homebudget.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.edu.wszib.homebudget.domain.Expense;

@Controller
public class MainController {

    @GetMapping
    public String entry() {
        return "entry";
    }

    @GetMapping("/expenses")
    public String latest() {
        return "expenses";
    }

    @GetMapping("/expenses/new")
    public String newExpense(Model model) {
        model.addAttribute("outgo", new Expense());
        return "expense";
    }

    @GetMapping("/expenses/edit/{id}")
    public String editExpense(@PathVariable Long id, Model model) {
        /*write code with interface methods when defined*/
        return "expense";
    }

    @GetMapping("/incomes")
    public String income() {
        return "incomes";
    }

    @GetMapping("/incomes/new")
    public String newIncome(Model model) {
        model.addAttribute("income", new Expense());
        return "income";
    }

    @GetMapping("/incomes/edit/{id}")
    public String editIncome(@PathVariable Long id, Model model) {
        /*write code with interface methods when defined*/
        return "income";
    }

    @GetMapping("/monthly-balance")
    public String month() {
        return "monthly-balance";
    }

    @GetMapping("/annual-balance")
    public String year() {
        return "annual-balance";
    }

    @GetMapping("/stats")
    public String stats() {
        return "stats";
    }


}
