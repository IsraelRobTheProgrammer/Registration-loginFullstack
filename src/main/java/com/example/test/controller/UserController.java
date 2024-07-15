package com.example.test.controller;

import com.example.test.entity.UserDto;
import com.example.test.repository.UserRepository;
import com.example.test.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {


    private final UserService userService;

    public  UserController(UserService userService){
        this.userService = userService;
    }


    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("registerRequest", new UserDto());


        return "register_page";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model){

        model.addAttribute("loginRequest", new UserDto());
        return "login_page";
    }

    @PostMapping("/register")
        public String register(@ModelAttribute UserDto userDto ){
            System.out.println("register request: " + userDto);
         UserDto registeredUser = userService.registerUser(
                 userDto.getFirstName(), userDto.getLastName(), userDto.getMatric(), userDto.getModeOfEntry(),
                 userDto.getYearOfEntry(), userDto.getEmail(),userDto.getPassword(), userDto.getDob(),
                 userDto.getFaculty(), userDto.getDepartment(), userDto.getGender(), userDto.getLevel(),
                 userDto.getStateOfOrigin(), userDto.getPhoneNumber(),  userDto.getAge(),userDto.getParentPhoneNumber(),
                 userDto.getHomeAddress(), userDto.getMedicalId(), userDto.getLocalGovernment()



                 );


        return  registeredUser == null ? "error_page" : "redirect:/login";

    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserDto userDto, Model model){
        System.out.println("login request: " + userDto);
        UserDto authenticated = userService.authenticate(  userDto.getMatric(),userDto.getPassword() );
        if (authenticated != null){
            model.addAttribute("userName", authenticated.getFirstName());
            return "personal_page";
        } else{
            return "error_page";
        }

    }
}
