package ua.donordp.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.donordp.model.User;
import ua.donordp.service.UserService;

import java.io.IOException;

/**
 * Created by user on 18.04.17.
 */

@Controller
@RequestMapping("/users")
public class UserController {

    public UserController(UserService userService) {
        this.userService = userService;
    }

    private UserService userService;

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String addUser(@RequestBody String json) {


        try {
            User user = new ObjectMapper().readValue(json, User.class);
            this.userService.addUser(user);

            return "User successfully added!";

        } catch (IOException e) {
            return "ERROR JSON!";
        }
    }




}