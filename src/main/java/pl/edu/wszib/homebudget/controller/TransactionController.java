package pl.edu.wszib.homebudget.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.edu.wszib.homebudget.dao.TransactionDao;

@Controller
public class TransactionController {


    @Autowired
    private TransactionDao transactionDao;

    @GetMapping
    public String welcome() {
        return "entry";
    }

/*    @GetMapping()
    public String transactions(Model model) {
        model.addAttribute("transactions", transactionDao.findAll());
        return "transactions";
    }*/


}
