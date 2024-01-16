package com.jobportal.server.controller;

import com.jobportal.server.DataSetInMemory;
import com.jobportal.server.dto.LoginDto;
import com.jobportal.server.entity.User;
import com.jobportal.server.service.JobService;
import com.jobportal.server.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;
    private JobService jobService;


    @GetMapping("candidate-login")
    public String userLogin(@ModelAttribute("formModel") User formModel) {
        return "user-login";
    }

    @GetMapping("candidate-logout")
    public String userLogout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }


    @PostMapping("authenticate-user")
    public String authUser(@Valid LoginDto user, BindingResult result, Model model, HttpServletRequest request, HttpServletResponse response) {
        if(result.hasErrors()) {
            return "candidate-login";
        }
        User loggedInUser = userService.authenticate(user.email, user.password);
        if(loggedInUser != null){
            //dataSetInMemory
            HttpSession session = request.getSession();
            session.setAttribute("userId", loggedInUser.getId());
            session.setAttribute("email", user.email);
            session.setAttribute("firstName", loggedInUser.getFirstName());
            session.setAttribute("lastName", loggedInUser.getLastName());
            session.setAttribute("userType", "CANDIDATE");
            // create a cookie
         /*   Cookie cookie = new Cookie("username", user.email);
            cookie.setAttribute("firstName", loggedInUser.getFirstName());
            cookie.setAttribute("lastName", loggedInUser.getLastName());
            cookie.setSecure(false);
            cookie.setHttpOnly(true);
            // add a cookie to the response
            response.addCookie(cookie);*/

            System.out.println(user.email);
            // this.userService.createUser(user);
            return "redirect:candidate-home";
        }
        return "candidate-login";
    }

    @GetMapping("candidate-home")
    public String userLoginHome(@ModelAttribute("formModel") User formModel,Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String fName = (String) session.getAttribute("firstName");
        String lName = (String) session.getAttribute("lastName");
        model.addAttribute("firstName", fName);
        model.addAttribute("lastName", lName);
        return "user-home";
    }


    @GetMapping("add-user")
    public String showUserForm(@ModelAttribute("formModel") User formModel) {
        return "add-user";
    }
    @GetMapping("test")
    public String test(User user) {
        return "test";
    }

    @GetMapping("list")
    public String listUsers(Model model) {
        model.addAttribute("users", this.userService.getAllUsers());
        return "list-user";
    }

    @PostMapping("add")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "add-user";
        }
        this.userService.createUser(user);
        return "redirect:list";
    }

    // build create User REST API
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // build get user by id REST API
    // http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
        User user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // Build Get All Users REST API
    // http://localhost:8080/api/users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Build Update User REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/users/1
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId,
                                           @RequestBody User user){
        user.setId(userId);
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // Build Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
}