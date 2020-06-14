package pl.edu.wszib.homebudget.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.wszib.homebudget.dao.UserDao;
import pl.edu.wszib.homebudget.domain.User;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    UserDao userDao;

    @GetMapping("customize")
    public String settings(Model model) {
        model.addAttribute("users", userDao.findAll());
        return "settings";
    }

    @GetMapping("customize/set_user")
    public String userSet(Model model) {
        model.addAttribute("user", new User());
        return "user-set";
    }

    @GetMapping("customize/user/{id}")
    public String editUserForm(@PathVariable long id, Model model) {
        model.addAttribute("user", userDao.findById(id));
        return "user-set";
    }

    @PostMapping("customize/user/save")
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            return "user-set";
        }
        userDao.save(user);
        return "redirect:/customize";
    }

    @GetMapping("customize/delete/{id}")
    public String defaultUserSet(@PathVariable long id) {
        userDao.deleteById(id);
        return "redirect:/customize";
    }
}
