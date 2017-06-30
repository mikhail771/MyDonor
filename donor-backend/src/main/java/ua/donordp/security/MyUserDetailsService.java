package ua.donordp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.donordp.dao.UserDao;
import ua.donordp.model.User;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by stephenvolf on 29/06/17.
 */
@Service("myUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    private final UserDao userDao;

    @Autowired
    public MyUserDetailsService(UserDao userDao){
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.userByName(s);

        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), userAuthorities(user));
    }

    private List<GrantedAuthority> userAuthorities(User user){
        List<GrantedAuthority> result = new LinkedList<>();
        result.add(new SimpleGrantedAuthority("ROLE_USER"));
        return result;
    }
}
