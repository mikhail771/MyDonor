package ua.donordp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.donordp.service.SecurityService;
import ua.donordp.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class LoginController {

    private UserService userService;

    private SecurityService securityService;

    @Autowired
    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }


    @RequestMapping(value="/logoutt", method = RequestMethod.GET)
    public ResponseEntity logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return new ResponseEntity(HttpStatus.CHECKPOINT);
    }

    @RequestMapping(value="/auth", method = RequestMethod.GET)
    public String uName (HttpServletRequest request, HttpServletResponse response) {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @RequestMapping(value="/z", method = RequestMethod.GET)
    public String uName2 (HttpServletRequest request, HttpServletResponse response) {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
