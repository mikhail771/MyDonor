package ua.donordp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.donordp.model.User;
import ua.donordp.service.UserService;

/**
 * Created by user on 18.04.17.
 */

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    public UserController( UserService userService) {
        this.userService = userService;
    }

    private UserService userService;


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity addUser(@RequestBody User  user) {

        this.userService.addUser(user);
        return ResponseEntity.created(null).build();
    }




}