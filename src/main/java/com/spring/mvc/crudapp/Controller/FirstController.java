package com.spring.mvc.crudapp.Controller;

import com.spring.mvc.crudapp.Service.UserService;
import com.spring.mvc.crudapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FirstController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    public String firstView(ModelMap modelMap) {
        List<String> list = new ArrayList<>();
        list.add("Hello!");
        list.add("You are welcome to main page");
        modelMap.addAttribute("hello", list);
        return "index";
    }

    @RequestMapping(value = "/users")
    public String listOfUsers(Model modelMap) {
        List<User> list = userService.getListUsers();
        modelMap.addAttribute("listOfUsers", list);
        return "users";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(@ModelAttribute("user") User user) {
        return "user-info";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @RequestMapping("/update")
    public String updateUser(Model model, @RequestParam("id2") int id) {
        User user = userService.findById((long) id);
        model.addAttribute("user", user);
        return "update";
    }

    @RequestMapping("/update/user")
    public String update(@ModelAttribute("user") User user,
                         @RequestParam("id") int id) {
        userService.update((long) id, user);
        return "redirect:/users";
    }

    @RequestMapping("/delete")
    public String deleteUser(@RequestParam("id") int id) {
        userService.deleteUserById((long) id);
        return "redirect:/users";
    }


}
