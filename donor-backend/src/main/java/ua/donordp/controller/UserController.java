package ua.donordp.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ua.donordp.model.User;
import ua.donordp.service.UserService;

import java.net.URI;
import java.util.List;

/**
 * Created by user on 08.06.17.
 */
@RestController
@RequestMapping("/registration")
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List userList(){
        return this.userService.userList();
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity addUser(@RequestBody User user){
        this.userService.addUser(user);
        return ResponseEntity.created(URI.create("/registration")).build();
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public @ResponseBody
    ResponseEntity removeUser(@PathVariable String id) {
        userService.removeUser(Integer.parseInt(id));
        return ResponseEntity.created(URI.create("/users")).build();
    }

    @CrossOrigin
    @RequestMapping("update/{id}")
    public String updateUser(@PathVariable("id") int id, @RequestBody User user){
        user.setId(id);
        userService.updateUser(user);

        return "users";
    }
}