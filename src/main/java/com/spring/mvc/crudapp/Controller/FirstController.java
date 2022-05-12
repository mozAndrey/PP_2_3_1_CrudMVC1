package com.spring.mvc.crudapp.Controller;

import com.spring.mvc.crudapp.Service.UserService;
import com.spring.mvc.crudapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Controller
@RequestMapping("/user")
public class FirstController {
    private UserService userService;

    private final static Logger LOGGER = Logger.getLogger(FirstController.class.getName());

    @Autowired
    public FirstController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/listOfUsers")
    public String listOfUsers(Model modelMap) {
        modelMap.addAttribute("listOfUsers", userService.getListUsers());
        return "users";
    }

    @GetMapping(value = "/addNewUser")
    public String addNewUser(@ModelAttribute("user") User user) {
        return "user-info";
    }

    @PostMapping(value = "/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/user/listOfUsers";
    }

    @GetMapping(value = "/update")
    public String updateUser(Model model, @RequestParam("idToUpdate") long id) {
        model.addAttribute("userToUpdate", userService.findById(id));
        return "update";
    }

    @PatchMapping(value = "/update/u")
    public String update(@ModelAttribute("userToUpdate") User user) {
        userService.update(user);
        return "redirect:/user/listOfUsers";
    }

    @DeleteMapping(value = "/delete")
    public String deleteUser(@RequestParam("id") long id) {
        userService.deleteUserById(id);
        return "redirect:/user/listOfUsers";
    }


}
